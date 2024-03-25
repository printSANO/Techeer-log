package consolelog.member.exception;

import consolelog.global.response.ErrorCode;
import consolelog.global.exception.BusinessException;

public class InvalidPasswordFormatException extends BusinessException {


    public InvalidPasswordFormatException() {
        super(ErrorCode.INVALID_PASSWORD_FORM_ERROR);
    }
}
