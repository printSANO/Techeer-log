package consolelog.post.exception;

import consolelog.global.advice.NotFoundException;
import consolelog.global.error.ErrorCode;

public class PostNotFoundException extends NotFoundException {

    public PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND_ERROR);
    }
}
