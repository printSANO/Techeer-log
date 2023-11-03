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
import consolelog.post.domain.Post;
import consolelog.post.exception.PostNotFoundException;
import consolelog.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class LikeService {
    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final CommentLikeRepository commentLikeRepository;
    private final CommentRepository commentRepository;


    public LikeService(PostLikeRepository postLikeRepository, PostRepository postRepository,
                       MemberRepository memberRepository, CommentLikeRepository commentLikeRepository, CommentRepository commentRepository) {

        this.postLikeRepository = postLikeRepository;
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
        this.commentLikeRepository = commentLikeRepository;
        this.commentRepository = commentRepository;
    }

    //checkAuthority(authinfo, postId) 사용여부 확인
    @Transactional
    public LikeFlipResponse flipPostLike(Long postId, AuthInfo authInfo) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
        int likeCount = flipPostLike(authInfo.getId(), post);
        boolean liked = postLikeRepository.existsByPostAndMemberId(post, authInfo.getId());

        return new LikeFlipResponse(likeCount, liked);
    }

    private int flipPostLike(Long memberId, Post post) {
        final Optional<PostLike> postLike = postLikeRepository.findByPostAndMemberId(post, memberId);
        if (postLike.isPresent()) {
            post.deleteLike(postLike.get());
            postRepository.decreaseLikeCount(post.getId());
            return post.getLikeCount() - 1;
        }
        addNewPostLike(memberId, post);
        postRepository.increaseLikeCount(post.getId());
        return post.getLikeCount() + 1;
    }

    private void addNewPostLike(Long memberId, Post post) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(MemberNotFoundException::new);
        PostLike postLike = PostLike.builder()
                .post(post)
                .member(member)
                .build();
        postLikeRepository.save(postLike);
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
