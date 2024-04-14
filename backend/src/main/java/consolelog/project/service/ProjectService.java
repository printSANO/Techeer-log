package consolelog.project.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.auth.exception.AuthorizationException;
import consolelog.comment.repository.CommentRepository;
import consolelog.global.support.UtilMethod;
import consolelog.love.repository.LikeRepository;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import consolelog.project.domain.Project;
import consolelog.project.domain.ProjectMember;
import consolelog.project.domain.ViewCountManager;
import consolelog.project.dto.*;
import consolelog.project.exception.ProjectNotFoundException;
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
    private final ProjectMemberRepository projectMemberRepository;
    private final MemberRepository memberRepository;

    public ProjectService(ProjectRepository projectRepository,
                          CommentRepository commentRepository,
                          LikeRepository likeRepository,
                          ViewCountManager viewCountManager,
                          UtilMethod utilMethod, ProjectMapper projectMapper, ProjectMemberRepository projectMemberRepository,
                          MemberRepository memberRepository) { // 생성자 주입
        this.projectRepository = projectRepository;  // 생성자를 통해 PostRepository를 주입받음
        this.likeRepository = likeRepository;
        this.viewCountManager = viewCountManager;
        this.commentRepository = commentRepository;
        this.utilMethod = utilMethod;
        this.projectMapper = projectMapper;
        this.projectMemberRepository = projectMemberRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public ProjectResponse findProject(Long projectId, String cookieValue) {
        if (viewCountManager.isFirstAccess(cookieValue, projectId)) {
            projectRepository.updateViewCount(projectId);
        }
        Project findProject = findProjectById(projectId);

        return projectMapper.projectToProjectResponse(findProject);
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

        List<ProjectMember> projectMemberList = getProjectMemberList(savedProject, projectRequest.getProjectMemberDTOList());
        projectMemberRepository.saveAll(projectMemberList);


        return savedProject.orElseThrow(ProjectNotFoundException::new).getId();
    }

    private List<ProjectMember> getProjectMemberList(Optional<Project> savedProject, List<ProjectMemberDTO> projectMemberDTOList) {
        List<ProjectMember> projectMemberList = new ArrayList<>();

        for (ProjectMemberDTO projectMemberDTO : projectMemberDTOList) {
            ProjectMember projectMember = new ProjectMember();
            Optional<Member> member = memberRepository.findById(projectMemberDTO.getMemberId());

            projectMember.setProject(savedProject.orElseThrow(ProjectNotFoundException::new));
            projectMember.setMember(member.orElseThrow(MemberNotFoundException::new));
            projectMember.setProjectMemberEnum(projectMemberDTO.getProjectMemberTypeEnum());

            projectMemberList.add(projectMember);
        }
        return projectMemberList;
    }

    private void validateMemberList(ProjectRequest projectRequest) {
        for (ProjectMemberDTO projectMemberDTO : projectRequest.getProjectMemberDTOList()) {
            utilMethod.validateMemberId(projectMemberDTO.getMemberId());
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



