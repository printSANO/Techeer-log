package consolelog.member.exception;

import consolelog.global.advice.BadRequestException;
import consolelog.global.error.ErrorCode;

public class PasswordConfirmationException extends BadRequestException {


    public PasswordConfirmationException() {
        super(ErrorCode.PASSWORD_CONFIRMATION_ERROR);
    }
}
