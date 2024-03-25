package consolelog.comment.exception;


import consolelog.global.exception.BusinessException;
import consolelog.global.error.ErrorCode;

public class CommentNotFoundException extends BusinessException {


    public CommentNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND_ERROR);
    }
}
