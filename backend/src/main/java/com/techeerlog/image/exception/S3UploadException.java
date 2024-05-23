package com.techeerlog.image.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class S3UploadException extends BusinessException {
    public S3UploadException() {
        super(ErrorCode.S3_UPLOAD_ERROR);
    }
}
