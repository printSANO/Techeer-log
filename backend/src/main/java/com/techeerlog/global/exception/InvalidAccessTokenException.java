package com.techeerlog.global.exception;


import com.techeerlog.global.response.ErrorCode;

public class InvalidAccessTokenException extends BusinessException {

    public InvalidAccessTokenException() {
        super(ErrorCode.INVALID_ACCESS_TOKEN_ERROR);
    }
}
