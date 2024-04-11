package consolelog.like.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.comment.domain.Comment;
import consolelog.comment.exception.CommentNotFoundException;
import consolelog.comment.repository.CommentRepository;
import consolelog.like.domain.CommentLike;
import consolelog.like.domain.PostLike;
import consolelog.like.dto.LikeFlipResponse;
import consolelog.like.repository.CommentLikeRepository;
import consolelog.like.repository.PostLikeRepository;
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
    private final PostLikeRepository postLikeRepository;
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final CommentLikeRepository commentLikeRepository;
    private final CommentRepository commentRepository;


    public LikeService(PostLikeRepository postLikeRepository, ProjectRepository projectRepository,
                       MemberRepository memberRepository, CommentLikeRepository commentLikeRepository, CommentRepository commentRepository) {

        this.postLikeRepository = postLikeRepository;
        this.projectRepository = projectRepository;
        this.memberRepository = memberRepository;
        this.commentLikeRepository = commentLikeRepository;
        this.commentRepository = commentRepository;
    }

    //checkAuthority(authinfo, postId) 사용여부 확인
    @Transactional
    public LikeFlipResponse flipPostLike(Long postId, AuthInfo authInfo) {
        Project project = projectRepository.findById(postId)
                .orElseThrow(ProjectNotFoundException::new);
        int likeCount = flipPostLike(authInfo.getId(), project);
        boolean liked = postLikeRepository.existsByProjectAndMemberId(project, authInfo.getId());

        return new LikeFlipResponse(likeCount, liked);
    }

    private int flipPostLike(Long memberId, Project project) {
        final Optional<PostLike> postLike = postLikeRepository.findByPostAndMemberId(project, memberId);
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
        PostLike postLike = PostLike.builder()
                .project(project)
                .member(member)
                .build();
        postLikeRepository.save(postLike);
    }

    @Transactional
    // 수정 필요
    // 반환값이 사용되지 않음
    public LikeFlipResponse flipCommentLike(Long commentId, AuthInfo authInfo) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);

        int likeCount = flipCommentLike(authInfo.getId(), comment);
        boolean liked = commentLikeRepository.existsByMemberIdAndComment(authInfo.getId(), comment);

        return new LikeFlipResponse(likeCount, liked);
    }

    private int flipCommentLike(Long memberId, Comment comment) {
        Optional<CommentLike> commentLike = commentLikeRepository.findByMemberIdAndComment(memberId, comment);
        if (commentLike.isPresent()) {
            comment.deleteLike(commentLike.get());
            commentRepository.decreaseLikeCount(comment.getId());
            return comment.getCommentLikesCount() - 1;
        }
        addNewCommentLike(memberId, comment);
        commentRepository.increaseLikeCount(comment.getId());
        return comment.getCommentLikesCount() + 1;
    }

    private void addNewCommentLike(Long memberId, Comment comment) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);
        CommentLike commentLike = CommentLike.builder()
                .member(member)
                .comment(comment)
                .build();
        commentLikeRepository.save(commentLike);
    }
}
