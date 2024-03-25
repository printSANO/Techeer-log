package consolelog.post.exception;

import consolelog.global.error.ErrorCode;
import consolelog.global.exception.BusinessException;

public class InvalidTitleException extends BusinessException {

    public InvalidTitleException() {
        super(ErrorCode.INVALID_TITLE_ERROR);
    }
}
