package consolelog.auth.exception;

import consolelog.global.exception.BusinessException;
import consolelog.global.error.ErrorCode;

public class AuthorizationException extends BusinessException {

    public AuthorizationException() {
        super(ErrorCode.AUTHORIZED_ERROR);
    }
}
