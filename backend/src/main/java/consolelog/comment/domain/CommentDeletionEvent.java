package consolelog.comment.domain;

import lombok.Getter;

@Getter
// 댓글이 삭제됐을 때 발생하는 이벤트 처리
public class CommentDeletionEvent {

    public final Long commentId;

    public CommentDeletionEvent(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentId() {
        return commentId;
    }
}
