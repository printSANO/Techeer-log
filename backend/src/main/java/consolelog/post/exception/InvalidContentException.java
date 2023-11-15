package consolelog.post.exception;

import consolelog.global.advice.BadRequestException;
import consolelog.global.error.ErrorCode;

public class InvalidContentException extends BadRequestException {

    public InvalidContentException() {
        super(ErrorCode.INVALID_CONTENT_ERROR);
    }
}
