package com.techeerlog.global.exception;


import com.techeerlog.global.response.ErrorCode;

public class InvalidRefreshTokenException extends BusinessException {

    public InvalidRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN_ERROR);
    }
}
