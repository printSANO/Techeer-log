package consolelog.member.exception;

import consolelog.global.error.ErrorCode;
import consolelog.global.exception.BusinessException;

public class InvalidLoginIdException extends BusinessException {


    public InvalidLoginIdException() {
        super(ErrorCode.INVALID_LOGIN_ID_ERROR);
    }
}
