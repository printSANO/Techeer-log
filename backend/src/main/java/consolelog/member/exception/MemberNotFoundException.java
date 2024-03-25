package consolelog.member.exception;

import consolelog.global.exception.BusinessException;
import consolelog.global.error.ErrorCode;

public class MemberNotFoundException extends BusinessException {

    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND_ERROR);
    }
}
