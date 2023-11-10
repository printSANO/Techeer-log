package consolelog.auth.exception;

import consolelog.global.advice.ForbiddenException;
import consolelog.global.error.ErrorCode;

public class AuthorizationException extends ForbiddenException {
    private static final String MESSAGE = "권한이 없습니다.";

    public AuthorizationException() {
        super(ErrorCode.AUTHORIZED_ERROR);
    }
}
