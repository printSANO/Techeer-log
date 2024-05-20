package com.techeerlog.auth.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class AuthorizationException extends BusinessException {

    public AuthorizationException() {
        super(ErrorCode.AUTHORIZED_ERROR);
    }
}
