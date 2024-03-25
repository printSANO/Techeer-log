package consolelog.image.exception;

import consolelog.global.exception.BusinessException;
import consolelog.global.error.ErrorCode;

public class S3UploadException extends BusinessException {
    public S3UploadException() {
        super(ErrorCode.S3_UPLOAD_ERROR);
    }
}
