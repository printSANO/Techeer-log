package consolelog.love.exception;


import consolelog.global.exception.BusinessException;
import consolelog.global.response.ErrorCode;

public class LikeNotFoundException extends BusinessException {


    public LikeNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND_ERROR);
    }
}
