package consolelog.comment.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class CommentNotFoundException extends ChangeSetPersister.NotFoundException {

    private static final String MESSAGE = "댓글을 찾을 수 없습니다.";

    public CommentNotFoundException() {
        super(MESSAGE);
    }
}
