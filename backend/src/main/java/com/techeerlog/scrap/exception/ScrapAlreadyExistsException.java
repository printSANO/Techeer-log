package com.techeerlog.scrap.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class ScrapAlreadyExistsException extends BusinessException {
    public ScrapAlreadyExistsException() {
        super(ErrorCode.SCRAP_DUPLICATE_ERROR);
    }
}
