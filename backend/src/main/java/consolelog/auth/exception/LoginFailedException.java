package consolelog.auth.exception;

import consolelog.global.advice.UnauthorizedException;
import consolelog.global.error.ErrorCode;

public class LoginFailedException extends UnauthorizedException {

    public LoginFailedException() {
        super(ErrorCode.LOGIN_FAILED_ERROR);
    }
}
