package com.techeerlog.scrap.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class ScrapNotFoundException extends BusinessException {
    public ScrapNotFoundException() {
        super(ErrorCode.SCRAP_NOT_FOUND_ERROR);
    }
}
