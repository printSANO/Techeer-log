package consolelog.comment.exception;

import consolelog.comment.advice.BadRequestException;

public class InvalidMessageException extends BadRequestException {
    private static final String MESSAGE = "댓글은 1자이상 500자 이하여야 합니다.";

    public InvalidMessageException() {
        super(MESSAGE);
    }
}
