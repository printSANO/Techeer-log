package consolelog.post.exception;

import consolelog.global.exception.BusinessException;
import consolelog.global.response.ErrorCode;

public class PostNotFoundException extends BusinessException {

    public PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND_ERROR);
    }
}
