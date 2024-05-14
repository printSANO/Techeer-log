package com.techeerlog.love.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class LoveAccessDeniedException extends BusinessException {
    public LoveAccessDeniedException() {
        super(ErrorCode.AUTHORIZED_ERROR);
    }

}
