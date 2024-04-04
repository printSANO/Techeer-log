package consolelog.member.exception;

import consolelog.global.response.ErrorCode;
import consolelog.global.exception.BusinessException;

public class InvalidNicknameException extends BusinessException {


    public InvalidNicknameException() {
        super(ErrorCode.INVALID_NICKNAME_ERROR);
    }
}
