package com.techeerlog.member.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class DuplicateNicknameException extends BusinessException {

    public DuplicateNicknameException() {
        super(ErrorCode.DUPLICATE_NICKNAME_ERROR);
    }
}
