package com.techeerlog.member.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class InvalidPasswordFormatException extends BusinessException {


    public InvalidPasswordFormatException() {
        super(ErrorCode.INVALID_PASSWORD_FORM_ERROR);
    }
}
