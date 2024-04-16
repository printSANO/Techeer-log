package consolelog.love.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.comment.repository.CommentRepository;
import consolelog.love.domain.Love;
import consolelog.love.dto.LikeFlipResponse;
import consolelog.love.repository.LikeRepository;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import consolelog.project.domain.Project;
import consolelog.project.exception.ProjectNotFoundException;
import consolelog.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class LikeService {
    private final LikeRepository likeRepository;
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;


    public LikeService(LikeRepository likeRepository, ProjectRepository projectRepository,
                       MemberRepository memberRepository, CommentRepository commentRepository) {

        this.likeRepository = likeRepository;
        this.projectRepository = projectRepository;
        this.memberRepository = memberRepository;
        this.commentRepository = commentRepository;
    }

    //checkAuthority(authinfo, postId) 사용여부 확인
    @Transactional
    public LikeFlipResponse flipPostLike(Long postId, AuthInfo authInfo) {
        Project project = projectRepository.findById(postId)
                .orElseThrow(ProjectNotFoundException::new);
        int likeCount = flipPostLike(authInfo.getId(), project);
        boolean liked = likeRepository.existsByProjectAndMemberId(project, authInfo.getId());

        return new LikeFlipResponse(likeCount, liked);
    }

    private int flipPostLike(Long memberId, Project project) {
        final Optional<Love> postLike = likeRepository.findByPostAndMemberId(project, memberId);
        if (postLike.isPresent()) {
            project.deleteLike(postLike.get());
            projectRepository.decreaseLikeCount(project.getId());
            return project.getLikeCount() - 1;
        }
        addNewPostLike(memberId, project);
        projectRepository.increaseLikeCount(project.getId());
        return project.getLikeCount() + 1;
    }

    private void addNewPostLike(Long memberId, Project project) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);
        Love love = Love.builder()
                .project(project)
                .member(member)
                .build();
        likeRepository.save(love);
    }
}
