package consolelog.comment.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class CommentLikeNotFoundException extends ChangeSetPersister.NotFoundException {

    private static final String MESSAGE = "해당 회원이 누른 좋아요가 존재하지 않습니다.";

    public CommentNotFoundException() {
        super(MESSAGE);
    }
}
