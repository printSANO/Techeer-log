package com.techeerlog.global.exception;


import com.techeerlog.global.response.ErrorCode;

public class NoAccessTokenException extends BusinessException {

    public NoAccessTokenException() {
        super(ErrorCode.NO_ACCESS_TOKEN_ERROR);
    }
}
