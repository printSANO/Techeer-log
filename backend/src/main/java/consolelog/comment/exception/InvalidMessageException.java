package consolelog.comment.exception;

import consolelog.global.response.ErrorCode;
import consolelog.global.exception.BusinessException;

public class InvalidMessageException extends BusinessException {

    public InvalidMessageException() {
        super(ErrorCode.INVALID_MESSAGE_ERROR);
    }
}
