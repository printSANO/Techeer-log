package com.techeerlog.project.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class InvalidContentException extends BusinessException {

    public InvalidContentException() {
        super(ErrorCode.INVALID_CONTENT_ERROR);
    }
}
