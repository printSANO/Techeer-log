package consolelog.member.exception;

import consolelog.global.advice.BadRequestException;
import consolelog.global.error.ErrorCode;

public class InvalidNicknameException extends BadRequestException {


    public InvalidNicknameException() {
        super(ErrorCode.INVALID_NICKNAME_ERROR);
    }
}
