package consolelog.member.exception;

import consolelog.global.response.ErrorCode;
import consolelog.global.exception.BusinessException;

public class InvalidSignupFlowException extends BusinessException {


    public InvalidSignupFlowException() {
        super(ErrorCode.INVALID_SIGNUP_FLOW_ERROR);
    }
}
