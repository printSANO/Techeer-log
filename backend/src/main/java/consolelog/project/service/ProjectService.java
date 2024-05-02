package consolelog.project.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.auth.exception.AuthorizationException;
import consolelog.framework.domain.Framework;
import consolelog.global.mapper.FrameworkMapper;
import consolelog.framework.dto.FrameworkRequest;
import consolelog.framework.dto.FrameworkResponse;
import consolelog.framework.exception.FrameworkNotFoundException;
import consolelog.framework.repository.FrameworkRepository;
import consolelog.global.mapper.ProjectMapper;
import consolelog.global.support.UtilMethod;
import consolelog.member.domain.Member;
import consolelog.global.mapper.MemberMapper;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import consolelog.project.domain.*;
import consolelog.project.dto.*;
import consolelog.project.enums.SearchFieldEnum;
import consolelog.project.exception.PageableAccessException;
import consolelog.project.exception.ProjectNotFoundException;
import consolelog.project.repository.NonRegisterProjectMemberRepository;
import consolelog.project.repository.ProjectFrameworkRepository;
import consolelog.project.repository.ProjectMemberRepository;
import consolelog.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ViewCountManager viewCountManager;
    private final UtilMethod utilMethod;
    private final ProjectMapper projectMapper;
    private final MemberMapper memberMapper;
    private final FrameworkMapper frameworkMapper;
    private final ProjectMemberRepository projectMemberRepository;
    private final MemberRepository memberRepository;
    private final FrameworkRepository frameworkRepository;
    private final ProjectFrameworkRepository projectFrameworkRepository;
    private final NonRegisterProjectMemberRepository nonRegisterProjectMemberRepository;

    @Transactional
    public ProjectResponse findProjectResponse(Long projectId, String cookieValue) {
        // 다른 함수에서 요청했을 때, Cookie 값에 "N" 을 넣는다
        if (!cookieValue.equals("N") || viewCountManager.isFirstAccess(cookieValue, projectId)) {
            projectRepository.updateViewCount(projectId);
        }
        Project findProject = findProjectById(projectId);

        ProjectResponse projectResponse = projectMapper.projectToProjectResponse(findProject);
        projectResponse.setWriter(memberMapper.memberToMemberResponse(findProject.getMember()));
        projectResponse.setProjectMemberResponseList(getProjectMemberResponseList(findProject.getProjectMemberList()));
        projectResponse.setNonRegisterProjectMemberResponseList(getNonRegisterProjectMemberResponseList(findProject.getNonRegisterProjectMemberList()));
        projectResponse.setFrameworkResponseList(getFrameworkResponseList(findProject.getProjectFrameworkList()));

        return projectResponse;
    }

    private List<NonRegisterProjectMemberResponse> getNonRegisterProjectMemberResponseList(List<NonRegisterProjectMember> nonRegisterProjectMemberList) {
        List<NonRegisterProjectMemberResponse> nonRegisterProjectMemberResponseList = new ArrayList<>();

        for (NonRegisterProjectMember nonRegisterProjectMember : nonRegisterProjectMemberList) {
            nonRegisterProjectMemberResponseList.add(nonRegisterProjectMember.getResponse());
        }
        return nonRegisterProjectMemberResponseList;
    }

    @Transactional
    public Long addProject(ProjectRequest projectRequest, AuthInfo authInfo) {
        validateMemberList(projectRequest);

        Member writer = utilMethod.findMemberByAuthInfo(authInfo);
        Project project = projectMapper.projectRequestToProject(projectRequest);
        project.setMember(writer);

        Optional<Project> projectOptional = Optional.of(projectRepository.save(project));
        Project savedProject = projectOptional.orElseThrow(ProjectNotFoundException::new);

        saveProjectMemberList(savedProject, projectRequest.getProjectMemberRequestList());
        saveProjectNonRegisterProjectMemberList(savedProject, projectRequest.getNonRegisterProjectMemberRequestList());
        saveProjectFrameworkList(savedProject, projectRequest.getFrameworkRequestList());

        return savedProject.getId();
    }

    private void saveProjectNonRegisterProjectMemberList(Project project, List<NonRegisterProjectMemberRequest> nonRegisterProjectMemberRequestList) {
        List<NonRegisterProjectMember> nonRegisterProjectMemberList = new ArrayList<>();
        for (NonRegisterProjectMemberRequest nonRegisterProjectMemberRequest : nonRegisterProjectMemberRequestList) {
            nonRegisterProjectMemberList.add(new NonRegisterProjectMember(project, nonRegisterProjectMemberRequest));
        }
        nonRegisterProjectMemberRepository.saveAll(nonRegisterProjectMemberList);
    }

    @Transactional
    public void updateProject(Long id, ProjectRequest projectRequest, AuthInfo authInfo) {
        Project project = findProjectById(id);
        validateOwner(authInfo, project);

        projectMapper.updateProjectFromRequest(projectRequest, project);
        projectRepository.save(project);

        deleteAllProjectMember(project);
        deleteAllNonRegisterProjectMember(project);
        deleteAllProjectFramework(project);
        saveProjectMemberList(project, projectRequest.getProjectMemberRequestList());
        saveProjectFrameworkList(project, projectRequest.getFrameworkRequestList());
    }


    @Transactional
    public void deleteProject(Long id, AuthInfo authInfo) {
        Project project = findProjectById(id);
        validateOwner(authInfo, project);
        projectRepository.delete(project);
    }

    public List<ProjectItemResponse> findProjectListResponse(ProjectListRequest projectListRequest) {
        Slice<Project> projectSlice = getProjectSlice(projectListRequest);

        return projectListToProjectResponseList(projectSlice.toList());
    }

    private List<ProjectItemResponse> projectListToProjectResponseList(List<Project> projectList) {
        List<ProjectItemResponse> projectItemResponseList = new ArrayList<>();

        for (Project project : projectList) {
            ProjectItemResponse projectItemResponse = projectMapper.projectToProjectItemResponse(project);
            projectItemResponse.setWriter(memberMapper.memberToMemberResponse(project.getMember()));

            projectItemResponseList.add(projectItemResponse);
        }

        return projectItemResponseList;
    }

    private Slice<Project> getProjectSlice(ProjectListRequest projectListRequest) {
        Slice<Project> projectSlice = null;

        int pageStart = projectListRequest.getPageStart();
        int pageSize = projectListRequest.getPageSize();
        SearchFieldEnum searchFieldEnum = projectListRequest.getSearchFieldEnum();
        Sort.Direction sortDirection = projectListRequest.getSortDirection();
        String keyword = projectListRequest.getKeyword();

        Pageable pageable = PageRequest.of(pageStart, pageSize, Sort.by(sortDirection, "id"));

        switch (searchFieldEnum) {
            case TITLE -> projectSlice = projectRepository.findAllByTitleContaining(keyword, pageable);
            case CONTENT -> projectSlice = projectRepository.findAllByContentContaining(keyword, pageable);
            case WRITER -> projectSlice = projectRepository.findAllByMemberId(Long.parseLong(keyword), pageable);
            case ALL -> projectSlice = projectRepository.findAllByTitleOrContentContaining(keyword, pageable);
        }

        if (projectSlice == null) {
            throw new PageableAccessException();
        }

        return projectSlice;
    }

    private void deleteAllProjectFramework(Project project) {
        projectFrameworkRepository.deleteAllByProjectId(project.getId());
    }

    private void deleteAllNonRegisterProjectMember(Project project) {
        nonRegisterProjectMemberRepository.deleteAllByProjectId(project.getId());
    }

    private void deleteAllProjectMember(Project project) {
        projectMemberRepository.deleteAllByProjectId(project.getId());
    }

    private void saveProjectFrameworkList(Project project, List<FrameworkRequest> frameworkRequestList) {
        List<ProjectFramework> projectFrameworkList = new ArrayList<>();

        for (FrameworkRequest frameworkRequest : frameworkRequestList) {
            ProjectFramework projectFramework = new ProjectFramework();

            Optional<Framework> framework = frameworkRepository.findByName(frameworkRequest.getName().toLowerCase());

            // framework 가 DB 에 없는 새로운 값인 경우 새로 객체를 만들고 DB 에 저장
            // 그리고 저장한 framework 를 가져온다
            if (framework.isEmpty()) {
                Framework newFramework = new Framework();
                newFramework.setName(frameworkRequest.getName().toLowerCase());
                newFramework.setFrameworkType(frameworkRequest.getFrameworkTypeEnum());

                framework = Optional.of(frameworkRepository.save(newFramework));
            }

            projectFramework.setProject(project);
            projectFramework.setFramework(framework.orElseThrow(FrameworkNotFoundException::new));

            projectFrameworkList.add(projectFramework);
        }
        projectFrameworkRepository.saveAll(projectFrameworkList);
    }

    private void saveProjectMemberList(Project project, List<ProjectMemberRequest> projectMemberRequestList) {
        List<ProjectMember> projectMemberList = getProjectMemberListByRequest(project, projectMemberRequestList);
        projectMemberRepository.saveAll(projectMemberList);
    }

    private List<ProjectMember> getProjectMemberListByRequest(Project project, List<ProjectMemberRequest> projectMemberRequestList) {
        List<ProjectMember> projectMemberList = new ArrayList<>();

        for (ProjectMemberRequest projectMemberRequest : projectMemberRequestList) {
            ProjectMember projectMember = new ProjectMember();
            Optional<Member> member = memberRepository.findById(projectMemberRequest.getMemberId());

            projectMember.setProject(project);
            projectMember.setMember(member.orElseThrow(MemberNotFoundException::new));
            projectMember.setProjectMemberType(projectMemberRequest.getProjectMemberTypeEnum());

            projectMemberList.add(projectMember);
        }
        return projectMemberList;
    }

    private void validateMemberList(ProjectRequest projectRequest) {
        for (ProjectMemberRequest projectMemberRequest : projectRequest.getProjectMemberRequestList()) {
            utilMethod.validateMemberId(projectMemberRequest.getMemberId());
        }
    }

    private List<FrameworkResponse> getFrameworkResponseList(List<ProjectFramework> projectFrameworkList) {
        List<FrameworkResponse> frameworkResponseList = new ArrayList<>();

        for (ProjectFramework projectFramework : projectFrameworkList) {
            FrameworkResponse frameworkResponse = frameworkMapper.frameworkToFrameworkResponse(projectFramework.getFramework());

            frameworkResponseList.add(frameworkResponse);
        }
        return frameworkResponseList;
    }

    private List<ProjectMemberResponse> getProjectMemberResponseList(List<ProjectMember> projectMemberList) {
        List<ProjectMemberResponse> projectMemberResponseList = new ArrayList<>();

        for (ProjectMember projectMember : projectMemberList) {
            ProjectMemberResponse projectMemberResponse = new ProjectMemberResponse();

            projectMemberResponse.setProjectMemberTypeEnum(projectMember.getProjectMemberType());
            projectMemberResponse.setMemberResponse(memberMapper.memberToMemberResponse(projectMember.getMember()));

            projectMemberResponseList.add(projectMemberResponse);
        }
        return projectMemberResponseList;
    }


    private Project findProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
    }

    public String updateProjectLog(Long projectId, String cookieValue) {
        return viewCountManager.getUpdatedLog(cookieValue, projectId);
    }

    private void validateOwner(AuthInfo authInfo, Project project) {
        if (!project.isOwner(authInfo.getId())) {
            throw new AuthorizationException();
        }
    }
}



