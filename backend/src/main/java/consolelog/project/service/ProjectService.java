package consolelog.project.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.auth.exception.AuthorizationException;
import consolelog.comment.repository.CommentRepository;
import consolelog.framework.domain.Framework;
import consolelog.framework.dto.FrameworkMapper;
import consolelog.framework.dto.FrameworkRequest;
import consolelog.framework.dto.FrameworkResponse;
import consolelog.framework.exception.FrameworkNotFoundException;
import consolelog.framework.repository.FrameworkRepository;
import consolelog.global.support.UtilMethod;
import consolelog.love.repository.LikeRepository;
import consolelog.member.domain.Member;
import consolelog.member.dto.MemberMapper;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import consolelog.project.domain.Project;
import consolelog.project.domain.ProjectFramework;
import consolelog.project.domain.ProjectMember;
import consolelog.project.domain.ViewCountManager;
import consolelog.project.dto.*;
import consolelog.project.exception.ProjectNotFoundException;
import consolelog.project.repository.ProjectFrameworkRepository;
import consolelog.project.repository.ProjectMemberRepository;
import consolelog.project.repository.ProjectRepository;
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
    public ProjectResponse findProject(Long projectId, String cookieValue) {
        if (viewCountManager.isFirstAccess(cookieValue, projectId)) {
            projectRepository.updateViewCount(projectId);
        }
        Project findProject = findProjectById(projectId);

        ProjectResponse projectResponse = projectMapper.projectToProjectResponse(findProject);
        projectResponse.setProjectMemberResponseList(getProjectMemberResponseList(findProject.getProjectMemberList()));
        projectResponse.setFrameworkResponseList(getFrameworkResponseList(findProject.getProjectFrameworkList()));

        return projectResponse;
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

//    public PagePostResponse findProjectByPage(Long lastProjectId, Pageable pageable) {
//        Slice<Project> posts;
//        if (lastProjectId == 0) {
//            posts = projectRepository.findNextPage(pageable);
//        } else {
//            posts = projectRepository.findProjectByIdIsLessThanOrderByIdDesc(lastProjectId, pageable);
//        }
//        return PagePostResponse.of(posts);
//
//    }

    @Transactional
    public Long addProject(ProjectRequest projectRequest, AuthInfo authInfo) {
        validateMemberList(projectRequest);

        Member writer = utilMethod.findMemberByAuthInfo(authInfo);
        Project project = projectMapper.projectRequestToProject(projectRequest);
        project.setMember(writer);

        Optional<Project> savedProject = Optional.of(projectRepository.save(project));

        saveProjectMemberList(savedProject, projectRequest.getProjectMemberRequestList());
        saveProjectFrameworkList(savedProject, projectRequest.getFrameworkRequestList());

        return savedProject.orElseThrow(ProjectNotFoundException::new).getId();
    }

    private void saveProjectFrameworkList(Optional<Project> savedProject, List<FrameworkRequest> frameworkRequestList) {
        List<ProjectFramework> projectFrameworkList = new ArrayList<>();

        for (FrameworkRequest frameworkRequest : frameworkRequestList) {
            ProjectFramework projectFramework = new ProjectFramework();

            Optional<Framework> framework = frameworkRepository.findByName(frameworkRequest.getName().toLowerCase());

            // framework 가 DB 에 없는 새로운 값인 경우 새로 객체를 만들고 DB 에 저장
            // 그리고 저장한 framework 를 가져온다
            if (framework.isEmpty()) {
                Framework newFramework = new Framework();
                newFramework.setName(frameworkRequest.getName().toLowerCase());
                newFramework.setFrameworkType(frameworkRequest.getFrameworkType());

                framework = Optional.of(frameworkRepository.save(newFramework));
            }

            projectFramework.setProject(savedProject.orElseThrow(ProjectNotFoundException::new));
            projectFramework.setFramework(framework.orElseThrow(FrameworkNotFoundException::new));

            projectFrameworkList.add(projectFramework);
        }
        projectFrameworkRepository.saveAll(projectFrameworkList);
    }

    private void saveProjectMemberList(Optional<Project> savedProject, List<ProjectMemberRequest> projectMemberRequestList) {
        List<ProjectMember> projectMemberList = getProjectMemberListByRequest(savedProject, projectMemberRequestList);
        projectMemberRepository.saveAll(projectMemberList);
    }

    private List<ProjectMember> getProjectMemberListByRequest(Optional<Project> savedProject, List<ProjectMemberRequest> projectMemberRequestList) {
        List<ProjectMember> projectMemberList = new ArrayList<>();

        for (ProjectMemberRequest projectMemberRequest : projectMemberRequestList) {
            ProjectMember projectMember = new ProjectMember();
            Optional<Member> member = memberRepository.findById(projectMemberRequest.getMemberId());

            projectMember.setProject(savedProject.orElseThrow(ProjectNotFoundException::new));
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

    @Transactional
    public ProjectResponse updateProject(Long id, ProjectRequest projectRequest, AuthInfo authInfo) {
        Project project = findProjectById(id);
        validateOwner(authInfo, project);

        projectMapper.updateProjectFromRequest(projectRequest, project);
        projectRepository.save(project);

        return projectMapper.projectToProjectResponse(project);
    }

    @Transactional
    public void deleteProject(Long id, AuthInfo authInfo) {
        Project project = findProjectById(id);
        validateOwner(authInfo, project);
        commentRepository.deleteAllByProject(project);
        likeRepository.deleteAllByProject(project);
        projectRepository.delete(project);
    }

    private void validateOwner(AuthInfo authInfo, Project project) {
        if (!project.isOwner(authInfo.getId())) {
            throw new AuthorizationException();
        }
    }
}



