package consolelog.member.exception;


import consolelog.global.advice.BadRequestException;
import consolelog.global.error.ErrorCode;

public class DuplicateNicknameException extends BadRequestException {

    public DuplicateNicknameException() {
        super(ErrorCode.DUPLICATE_NICKNAME_ERROR);
    }
}
