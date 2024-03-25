package consolelog.member.exception;

import consolelog.global.error.ErrorCode;
import consolelog.global.exception.BusinessException;

public class PasswordConfirmationException extends BusinessException {


    public PasswordConfirmationException() {
        super(ErrorCode.PASSWORD_CONFIRMATION_ERROR);
    }
}
