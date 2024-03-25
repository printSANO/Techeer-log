package consolelog.post.exception;

import consolelog.global.response.ErrorCode;
import consolelog.global.exception.BusinessException;

public class InvalidContentException extends BusinessException {

    public InvalidContentException() {
        super(ErrorCode.INVALID_CONTENT_ERROR);
    }
}
