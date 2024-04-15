package consolelog.comment.dto;

import consolelog.comment.domain.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

// 하나의 댓글 정보를 전달하기 위한 DTO >> 단일 댓글 정보를 클라이언트로 전송할 때 사용
@Getter
public class CommentResponse {

    private final Long commentId;
    private final String nickname;
    private final String profileImageUrl;
    private final String content;
    private final LocalDateTime createdAt;
    private final boolean authorized;
    // 수정 필요
    // 불필요한 인자값 삭제
    // 만약, authorized 가 필요한 값이면, 어디에 사용하는 값인지 주석 필요
    public CommentResponse(Long commentId, String nickname, String content, LocalDateTime createdAt,
                           boolean authorized, String profileImageUrl) {
        this.commentId = commentId;
        this.nickname = nickname;
        this.content = content;
        this.createdAt = createdAt;
        this.authorized = authorized;
        this.profileImageUrl = profileImageUrl;
    }

    public static CommentResponse of(Comment comment, Long accessMemberId) {
        return new CommentResponse(comment.getId(), comment.getMember().getNickname(), comment.getMessage(),
                comment.getCreatedAt(), comment.isAuthorized(accessMemberId),
                comment.getMember().getProfileImageUrl());
    }

    public static CommentResponse softRemovedOf(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                null,
                null,
                comment.getCreatedAt(),
                false,
                null);
    }

}
