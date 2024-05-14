package com.techeerlog.global.exception;


import com.techeerlog.global.response.ErrorCode;

public class ExternalLibraryException extends BusinessException {

    public ExternalLibraryException() {
        super(ErrorCode.EXTERNAL_LIBRARY_ERROR);
    }
}
