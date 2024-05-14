package com.techeerlog.member.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class InvalidLoginIdException extends BusinessException {


    public InvalidLoginIdException() {
        super(ErrorCode.INVALID_LOGIN_ID_ERROR);
    }
}
