package com.techeerlog.auth.exception;

import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class LoginFailedException extends BusinessException {

    public LoginFailedException() {
        super(ErrorCode.LOGIN_FAILED_ERROR);
    }
}
