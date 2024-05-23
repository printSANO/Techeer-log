package com.techeerlog.member.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class InvalidNicknameException extends BusinessException {


    public InvalidNicknameException() {
        super(ErrorCode.INVALID_NICKNAME_ERROR);
    }
}
