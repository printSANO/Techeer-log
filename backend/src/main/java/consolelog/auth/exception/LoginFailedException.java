package consolelog.auth.exception;

import consolelog.global.error.ErrorCode;
import consolelog.global.exception.BusinessException;

public class LoginFailedException extends BusinessException {

    public LoginFailedException() {
        super(ErrorCode.LOGIN_FAILED_ERROR);
    }
}
