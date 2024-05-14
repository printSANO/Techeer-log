package com.techeerlog.framework.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class FrameworkNotFoundException extends BusinessException {
    public FrameworkNotFoundException() {
        super(ErrorCode.FRAMEWORK_NOT_FOUND_ERROR);
    }
}
