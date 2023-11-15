package consolelog.comment.exception;


import consolelog.global.advice.NotFoundException;
import consolelog.global.error.ErrorCode;

public class CommentNotFoundException extends NotFoundException {


    public CommentNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND_ERROR);
    }
}
