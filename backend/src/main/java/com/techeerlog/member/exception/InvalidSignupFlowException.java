package com.techeerlog.member.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class InvalidSignupFlowException extends BusinessException {


    public InvalidSignupFlowException() {
        super(ErrorCode.INVALID_SIGNUP_FLOW_ERROR);
    }
}
