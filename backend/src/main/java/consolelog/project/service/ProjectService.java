package consolelog.project.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.auth.exception.AuthorizationException;
import consolelog.comment.repository.CommentRepository;
import consolelog.love.repository.LikeRepository;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import consolelog.project.domain.Project;
import consolelog.project.domain.ViewCountManager;
import consolelog.project.dto.ProjectRequest;
import consolelog.project.dto.ProjectResponse;
import consolelog.project.dto.PagePostResponse;
import consolelog.project.exception.ProjectNotFoundException;
import consolelog.project.repository.ProjectRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProjectService {
    private final ProjectRepository projectRepository; // final로 선언하면 생성자에서만 값을 할당할 수 있음
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;
    private final ViewCountManager viewCountManager;

    public ProjectService(ProjectRepository projectRepository, MemberRepository memberRepository,
                          CommentRepository commentRepository,
                          LikeRepository likeRepository,
                          ViewCountManager viewCountManager) { // 생성자 주입
        this.projectRepository = projectRepository;  // 생성자를 통해 PostRepository를 주입받음
        this.memberRepository = memberRepository;
        this.likeRepository = likeRepository;
        this.viewCountManager = viewCountManager;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public ProjectResponse findProject(Long projectId, String cookieValue) {
        if (viewCountManager.isFirstAccess(cookieValue, projectId)) {
            projectRepository.updateViewCount(projectId);
        }
        Project foundProject = findProjectById(projectId);
        return ProjectResponse.from(foundProject);
    }


    private Project findProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
    }

    public String updateProjectLog(Long projectId, String cookieValue) {
        return viewCountManager.getUpdatedLog(cookieValue, projectId);
    }

    public PagePostResponse findProjectByPage(Long lastProjectId, Pageable pageable) {
        Slice<Project> posts;
        if (lastProjectId == 0) {
            posts = projectRepository.findNextPage(pageable);
        } else {
            posts = projectRepository.findProjectByIdIsLessThanOrderByIdDesc(lastProjectId, pageable);
        }
        return PagePostResponse.of(posts);

    }

    @Transactional
    public Long addProject(ProjectRequest projectRequest, AuthInfo authInfo) {
        Member member = findMember(authInfo);
        Project project = createProject(projectRequest, member);
        Optional<Project> savedPost = Optional.of(projectRepository.save(project));
        return savedPost.orElseThrow(() -> new IllegalArgumentException("x")).getId();
    }

    private Member findMember(AuthInfo authInfo) {
        return memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);
    }

    private Project createProject(ProjectRequest projectRequest, Member member) {
        return Project.builder()
                .title(projectRequest.getTitle())
                .content(projectRequest.getContent())
                .mainImageUrl(projectRequest.getMainImageUrl())
                .member(member)
                .build();
    }

    @Transactional
    public ProjectResponse updateProject(Long id, ProjectRequest projectRequest, AuthInfo authInfo) {
        Project project = findProjectById(id);
        validateOwner(authInfo, project);
        project.updateTitle(projectRequest.getTitle());
        project.updateContent(projectRequest.getContent());
        project.setMainImageUrl(projectRequest.getMainImageUrl());
        return ProjectResponse.from(project);
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



