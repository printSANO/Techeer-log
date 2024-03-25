package consolelog.like.exception;


import consolelog.global.exception.BusinessException;
import consolelog.global.error.ErrorCode;

public class CommentLikeNotFoundException extends BusinessException {


    public CommentLikeNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND_ERROR);
    }
}
