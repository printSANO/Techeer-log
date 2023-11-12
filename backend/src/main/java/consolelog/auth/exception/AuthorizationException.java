package consolelog.auth.exception;

import consolelog.global.advice.ForbiddenException;
import consolelog.global.error.ErrorCode;

public class AuthorizationException extends ForbiddenException {

    public AuthorizationException() {
        super(ErrorCode.AUTHORIZED_ERROR);
    }
}
