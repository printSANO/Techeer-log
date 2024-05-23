package com.techeerlog.member.exception;

import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class PasswordConfirmationException extends BusinessException {


    public PasswordConfirmationException() {
        super(ErrorCode.PASSWORD_CONFIRMATION_ERROR);
    }
}
