package consolelog.member.exception;

import consolelog.global.advice.NotFoundException;
import consolelog.global.error.ErrorCode;

public class MemberNotFoundException extends NotFoundException {

    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND_ERROR);
    }
}
