package com.techeerlog.project.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class InvalidTitleException extends BusinessException {

    public InvalidTitleException() {
        super(ErrorCode.INVALID_TITLE_ERROR);
    }
}
