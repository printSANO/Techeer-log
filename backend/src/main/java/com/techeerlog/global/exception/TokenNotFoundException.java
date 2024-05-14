package com.techeerlog.global.exception;


import com.techeerlog.global.response.ErrorCode;

public class TokenNotFoundException extends BusinessException {

    public TokenNotFoundException() {
        super(ErrorCode.TOKEN_NOT_FOUND_ERROR);
    }
}
