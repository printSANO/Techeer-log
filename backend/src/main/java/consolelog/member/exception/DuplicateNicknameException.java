package consolelog.member.exception;


import consolelog.global.response.ErrorCode;
import consolelog.global.exception.BusinessException;

public class DuplicateNicknameException extends BusinessException {

    public DuplicateNicknameException() {
        super(ErrorCode.DUPLICATE_NICKNAME_ERROR);
    }
}
