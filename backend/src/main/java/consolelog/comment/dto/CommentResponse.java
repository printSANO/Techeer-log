package consolelog.comment.dto;

import consolelog.comment.domain.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

// 댓글 정보를 클라이언트로 응답하기 위한 목적
@Getter
public class CommentResponse {

    private final Long id;
    private final String nickname;
    private final String content;
    private final LocalDateTime created_at;
    private final boolean postWriter;
    private final boolean authorized;
    private final int likeCount;
    private final boolean like;
    private final List<ReplyResponse> replies;

    public CommentResponse(Long id, String nickname, String content, LocalDateTime created_at, boolean postWriter,
                           boolean authorized, int likeCount, boolean like,
                           List<ReplyResponse> replies) {
        this.id = id;
        this.nickname = nickname;
        this.content = content;
        this.created_at = created_at;
        this.postWriter = postWriter;
        this.authorized = authorized;
        this.likeCount = likeCount;
        this.like = like;
        this.replies = replies;
    }

    public static CommentResponse of(Comment comment, Long accessMemberId, List<ReplyResponse> replyResponses,
                                     boolean isLike) {
        return new CommentResponse(comment.getId(), comment.getNickname(), commet.getMessage(),
                comment.getCreated_at(), comment.isPostWriter(),
                comment.isAuthrized(accessMemberId), comment.getCommentLikesCount(), isLike, replyResponses);
    }

    public static CommentResponse softRemovedOf{Comment comment, List<ReplyResponse> replyResponses} {
        return new CommentResponse(comment.getId(), null, null, null, false)
    }

}
