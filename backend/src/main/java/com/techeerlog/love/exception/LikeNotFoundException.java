package com.techeerlog.love.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class LikeNotFoundException extends BusinessException {


    public LikeNotFoundException() {
        super(ErrorCode.COMMENT_LIKE_ALREADY_EXISTS_ERROR);
    }
}
