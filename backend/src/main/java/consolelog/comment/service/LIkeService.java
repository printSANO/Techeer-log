package consolelog.comment.service;

import consolelog.comment.dto.LikeFlipResponse;
import consolelog.comment.repository.CommentLikeRepository;
import consolelog.comment.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
        .orElseThrow(PostNotFoundException::new);
        authService.checkAuthority(authInfo, post.getBoardId());

        int likeCount = flipPostLike(authInfo.getId(), post);
        boolean liked = postLikeRepository.existsByPostAndMemberId(post, authInfo.getId());

        checkSpecialAndSave(likeCount, post);
        return new LikeFlipResponse(likeCount, liked);
    }


}
