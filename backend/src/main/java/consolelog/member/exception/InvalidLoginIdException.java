package consolelog.member.exception;

import consolelog.global.advice.BadRequestException;
import consolelog.global.error.ErrorCode;

public class InvalidLoginIdException extends BadRequestException {


    public InvalidLoginIdException() {
        super(ErrorCode.INVALID_LOGIN_ID_ERROR);
    }
}
