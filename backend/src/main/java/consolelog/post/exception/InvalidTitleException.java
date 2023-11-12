package consolelog.post.exception;

import consolelog.global.advice.BadRequestException;
import consolelog.global.error.ErrorCode;

public class InvalidTitleException extends BadRequestException {

    public InvalidTitleException() {
        super(ErrorCode.INVALID_TITLE_ERROR);
    }
}
