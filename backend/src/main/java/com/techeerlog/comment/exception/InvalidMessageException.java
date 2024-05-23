package com.techeerlog.comment.exception;

import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class InvalidMessageException extends BusinessException {

    public InvalidMessageException() {
        super(ErrorCode.INVALID_MESSAGE_ERROR);
    }
}
