package consolelog.project.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.auth.exception.AuthorizationException;
import consolelog.comment.repository.CommentRepository;
import consolelog.framework.domain.Framework;
import consolelog.global.mapper.FrameworkMapper;
import consolelog.framework.dto.FrameworkRequest;
import consolelog.framework.dto.FrameworkResponse;
import consolelog.framework.exception.FrameworkNotFoundException;
import consolelog.framework.repository.FrameworkRepository;
import consolelog.global.mapper.ProjectMapper;
import consolelog.global.support.UtilMethod;
import consolelog.love.repository.LikeRepository;
import consolelog.member.domain.Member;
import consolelog.global.mapper.MemberMapper;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import consolelog.project.domain.Project;
import consolelog.project.domain.ProjectFramework;
import consolelog.project.domain.ProjectMember;
import consolelog.project.domain.ViewCountManager;
import consolelog.project.dto.*;
import consolelog.project.enums.SearchFieldEnum;
import consolelog.project.exception.ProjectNotFoundException;
import consolelog.project.repository.ProjectFrameworkRepository;
import consolelog.project.repository.ProjectMemberRepository;
import consolelog.project.repository.ProjectRepository;
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
@Transactional(readOnly = true)
public class ProjectService {
    private final ProjectRepository projectRepository; // final로 선언하면 생성자에서만 값을 할당할 수 있음
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;
    private final ViewCountManager viewCountManager;
    private final UtilMethod utilMethod;
    private final ProjectMapper projectMapper;
    private final MemberMapper memberMapper;
    private final FrameworkMapper frameworkMapper;
    private final ProjectMemberRepository projectMemberRepository;
    private final MemberRepository memberRepository;
    private final FrameworkRepository frameworkRepository;
    private final ProjectFrameworkRepository projectFrameworkRepository;

    public ProjectService(ProjectRepository projectRepository,
                          CommentRepository commentRepository,
                          LikeRepository likeRepository,
                          ViewCountManager viewCountManager,
                          UtilMethod utilMethod, ProjectMapper projectMapper, MemberMapper memberMapper, FrameworkMapper frameworkMapper, ProjectMemberRepository projectMemberRepository,
                          MemberRepository memberRepository, FrameworkRepository frameworkRepository, ProjectFrameworkRepository projectFrameworkRepository) { // 생성자 주입
        this.projectRepository = projectRepository;  // 생성자를 통해 PostRepository를 주입받음
        this.likeRepository = likeRepository;
        this.viewCountManager = viewCountManager;
        this.commentRepository = commentRepository;
        this.utilMethod = utilMethod;
        this.projectMapper = projectMapper;
        this.memberMapper = memberMapper;
        this.frameworkMapper = frameworkMapper;
        this.projectMemberRepository = projectMemberRepository;
        this.memberRepository = memberRepository;
        this.frameworkRepository = frameworkRepository;
        this.projectFrameworkRepository = projectFrameworkRepository;
    }

    @Transactional
    public ProjectResponse findProjectResponse(Long projectId, String cookieValue) {
        if (viewCountManager.isFirstAccess(cookieValue, projectId)) {
            projectRepository.updateViewCount(projectId);
        }
        Project findProject = findProjectById(projectId);

        ProjectResponse projectResponse = projectMapper.projectToProjectResponse(findProject);
        projectResponse.setProjectMemberResponseList(getProjectMemberResponseList(findProject.getProjectMemberList()));
        projectResponse.setFrameworkResponseList(getFrameworkResponseList(findProject.getProjectFrameworkList()));

        return projectResponse;
    }
    @Transactional
    public ProjectResponse findProjectResponse(Long projectId) {
        Project project = findProjectById(projectId);

        ProjectResponse projectResponse = projectMapper.projectToProjectResponse(project);
        projectResponse.setProjectMemberResponseList(getProjectMemberResponseList(project.getProjectMemberList()));
        projectResponse.setFrameworkResponseList(getFrameworkResponseList(project.getProjectFrameworkList()));

        return projectResponse;
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
        saveProjectFrameworkList(savedProject, projectRequest.getFrameworkRequestList());

        return savedProject.getId();
    }
    @Transactional
    public void updateProject(Long id, ProjectRequest projectRequest, AuthInfo authInfo) {
        Project project = findProjectById(id);
        validateOwner(authInfo, project);

        projectMapper.updateProjectFromRequest(projectRequest, project);
        projectRepository.save(project);

        ProjectResponse projectResponse = projectMapper.projectToProjectResponse(project);

        deleteAllProjectMember(project);
        deleteAllProjectFramework(project);
        saveProjectMemberList(project, projectRequest.getProjectMemberRequestList());
        saveProjectFrameworkList(project, projectRequest.getFrameworkRequestList());
    }
    @Transactional
    public void deleteProject(Long id, AuthInfo authInfo) {
        Project project = findProjectById(id);
        validateOwner(authInfo, project);
        commentRepository.deleteAllByProject(project);
        likeRepository.deleteAllByProject(project);
        projectRepository.delete(project);
    }

    public List<ProjectResponse> findProjectListResponse(ProjectListRequest projectListRequest) {

        Slice<Project> projectSlice = getProjectSlice(projectListRequest);


        return projectMapper.projectListToProjectResponseList(projectSlice.toList());
    }

    private Slice<Project> getProjectSlice(ProjectListRequest projectListRequest) {
        Slice<Project> projectSlice = null;

        int pageStart = projectListRequest.getPageStart();
        int pageSize = projectListRequest.getPageSize();
        SearchFieldEnum searchFieldEnum = projectListRequest.getSearchFieldEnum();
        Sort.Direction sortDirection = projectListRequest.getSortDirection();
        String keyword = projectListRequest.getKeyword();

        Pageable pageable = PageRequest.of(pageStart, pageSize, Sort.by(sortDirection, "createdAt"));

        switch (searchFieldEnum) {
            case TITLE -> projectSlice = projectRepository.findAllByTitleContaining(keyword, pageable);
            case CONTENT -> projectSlice = projectRepository.findAllByContentContaining(keyword, pageable);
            case ALL -> projectSlice = projectRepository.findAllByTitleOrContentContaining(keyword, pageable);
        }

        return projectSlice;
    }

    private void deleteAllProjectFramework(Project project) {
        projectFrameworkRepository.deleteAllByProjectId(project.getId());
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



