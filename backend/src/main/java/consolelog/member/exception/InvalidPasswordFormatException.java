package consolelog.member.exception;

import consolelog.global.advice.BadRequestException;
import consolelog.global.error.ErrorCode;

public class InvalidPasswordFormatException extends BadRequestException {


    public InvalidPasswordFormatException() {
        super(ErrorCode.INVALID_PASSWORD_FORM_ERROR);
    }
}
