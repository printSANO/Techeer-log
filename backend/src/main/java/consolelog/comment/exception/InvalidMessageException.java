package consolelog.comment.exception;

import consolelog.global.advice.BadRequestException;
import consolelog.global.error.ErrorCode;

public class InvalidMessageException extends BadRequestException {

    public InvalidMessageException() {
        super(ErrorCode.INVALID_MESSAGE_ERROR);
    }
}
