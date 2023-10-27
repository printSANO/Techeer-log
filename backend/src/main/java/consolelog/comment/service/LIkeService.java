package consolelog.comment.service;

import consolelog.comment.domain.Comment;
import consolelog.comment.domain.CommentLike;
import consolelog.comment.dto.LikeFlipResponse;
import consolelog.comment.exception.CommentNotFoundException;
import consolelog.comment.repository.CommentLikeRepository;
import consolelog.comment.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class LIkeService {

    private static final int SPECIAL_BOARD_THRESHOLD = 5;

    private final BoardService boardService;
    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final CommentLikeRepository commentLikeRepository;
    private final MemberRepository memberRepository;
    private final AuthService authService;

    public LIkeService(BoardService boardService, PostLikeRepository postLikeRepository,
                       PostRepository postRepository, CommentRepository commentRepository,
                       CommentLikeRepository commentLikeRepository, MemberRepository memberRepository,
                       AuthService authService) {
        this.boardService = boardService;
        this.postLikeRepository = postLikeRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.commentLikeRepository = commentLikeRepository;
        this.memberRepository = memberRepository;
        this.authService = authService;
    }

    @Transactional
    public LikeFlipResponse flipResponse(Long postId, AuthInfo authInfo) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
        authService.checkAuthority(authInfo, post.getBoardId());

        int likeCount = flipPostLike(authInfo.getId(), post);
        boolean liked = postLikeRepository.existsByPostAndMemberId(post, authInfo.getId());

        checkSpecialAndSave(likeCount, post);
        return new LikeFlipResponse(likeCount, liked);
    }

//    //게시물 좋아요 수
//    private int flipPostLike(Long memberId, Post post) {
//        final Optional<PostLike> postLike = postLikeRepository.findByPostAndMemberId(post, memberId);
//        if (postLike.isPresent()) {
//            post.deleteLike(postLike.get());
//            postRepository.decreaseLikeCount(post.getId());
//            return post.getLikeCount() - 1;
//        }
//        addNewPostLike(memberId, post);
//        postRepository.increaseLikeCount(post.getId());
//        return post.getLikeCount() + 1;
//    }

//    private void addNewPostLike(Long memberId, Post post) {
//        Member member = memberRepository.findById(memberId)
//                .orElseThrow(MemberNotFoundException::new);
//        PostLike postLike = PostLike.builder()
//                .member(member)
//                .post(post)
//                .build();
//        postLikeRepository.save(postLike);
//    }

    private void checkSpecialAndSave(int likeCount, Post post) {
        if (likeCount >= SPECIAL_BOARD_THRESHOLD) {
            boardService.checkAndSaveInSpecialBoard(post);
        }
    }

    @Transactional
    public LikeFlipResponse flipCommentLike(Long commentId, AuthInfo authInfo) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);
        authService.checkAuthority(authInfo, comment.getBoardId());

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
