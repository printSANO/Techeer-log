package consolelog.global.advice;

import consolelog.global.error.ErrorCode;

public class UnauthorizedException extends BusinessException {

    public UnauthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
