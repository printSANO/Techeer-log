package consolelog.comment.dto;


import consolelog.comment.domain.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplyResponse {

    private final Long id;
    private final String nickname;
    private final String content;
    private final LocalDateTime created_at;
    private final boolean postWriter;
    private final boolean authorized;
    private final int likeCount;
    private final boolean like;

    public ReplyResponse(Long id, String nickname, String content, LocalDateTime created_at,
                         boolean postWriter, boolean authorized, int likeCount, boolean like) {
        this.id = id;
        this.nickname = nickname;
        this.content = content;
        this.created_at = created_at;
        this.postWriter = postWriter;
        this.authorized = authorized;
        this.likeCount = likeCount;
        this.like = like;
    }

    public static ReplyResponse of(Comment reply, Long accessMemberId, boolean like) {
        return new ReplyResponse(reply.getId(), reply.getNickname(), reply.getMessage(), reply.getCreated_at(),
                reply.isPostWriter(), reply.isAuthorized(accessMemberId),
                reply.getCommentLikesCount(), like);
    }
}
