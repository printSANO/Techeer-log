package consolelog.global.advice;

import consolelog.global.error.ErrorCode;

public class ForbiddenException extends BusinessException {

    public ForbiddenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
