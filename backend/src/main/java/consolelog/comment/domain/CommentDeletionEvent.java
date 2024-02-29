package consolelog.comment.domain;

import lombok.Getter;

// 댓글이 삭제됐을 때 발생하는 이벤트 처리
@Getter
public class CommentDeletionEvent {

    public final Long commentId;

    public CommentDeletionEvent(Long commentId) {
        this.commentId = commentId;
    }

    // 수정 필요
    // @Getter 가 있는데, getter 를 2번 선언함
    public Long getCommentId() {
        return commentId;
    }
}
