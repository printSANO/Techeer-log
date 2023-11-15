package consolelog.global.advice;

import consolelog.global.error.ErrorCode;

public class InternalException extends BusinessException {
    public InternalException(ErrorCode errorCode) {
        super(errorCode);
    }
}
