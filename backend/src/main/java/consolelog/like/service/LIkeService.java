package consolelog.like.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.auth.service.AuthService;
import consolelog.comment.domain.Comment;
import consolelog.comment.exception.CommentNotFoundException;
import consolelog.comment.repository.CommentRepository;
import consolelog.like.domain.CommentLike;
import consolelog.like.dto.LikeFlipResponse;
import consolelog.like.repository.CommentLikeRepository;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class LIkeService {
    private final CommentRepository commentRepository;
    private final CommentLikeRepository commentLikeRepository;
    private final MemberRepository memberRepository;
    private final AuthService authService;

    public LIkeService(CommentRepository commentRepository,
                       CommentLikeRepository commentLikeRepository, MemberRepository memberRepository,
                       AuthService authService) {
        this.commentRepository = commentRepository;
        this.commentLikeRepository = commentLikeRepository;
        this.memberRepository = memberRepository;
        this.authService = authService;
    }

    @Transactional
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
