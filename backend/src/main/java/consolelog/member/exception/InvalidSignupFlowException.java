package consolelog.member.exception;

import consolelog.global.advice.BadRequestException;
import consolelog.global.error.ErrorCode;

public class InvalidSignupFlowException extends BadRequestException {


    public InvalidSignupFlowException() {
        super(ErrorCode.INVALID_SIGNUP_FLOW_ERROR);
    }
}
