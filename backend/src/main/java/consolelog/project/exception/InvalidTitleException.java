package consolelog.project.exception;

import consolelog.global.response.ErrorCode;
import consolelog.global.exception.BusinessException;

public class InvalidTitleException extends BusinessException {

    public InvalidTitleException() {
        super(ErrorCode.INVALID_TITLE_ERROR);
    }
}
