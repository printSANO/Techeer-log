package consolelog.global.advice;

import consolelog.global.error.ErrorCode;

public class BadRequestException extends BusinessException {
    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}
