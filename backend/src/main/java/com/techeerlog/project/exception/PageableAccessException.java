package com.techeerlog.project.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class PageableAccessException extends BusinessException {

    public PageableAccessException() {
        super(ErrorCode.PAGEABLE_ACCESS_ERROR);
    }
}
