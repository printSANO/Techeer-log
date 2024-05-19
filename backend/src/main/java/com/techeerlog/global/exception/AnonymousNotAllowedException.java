package com.techeerlog.global.exception;


import com.techeerlog.global.response.ErrorCode;

public class AnonymousNotAllowedException extends BusinessException {

    public AnonymousNotAllowedException() {
        super(ErrorCode.ANONYMOUS_NOT_ALLOWED_ERROR);
    }
}
