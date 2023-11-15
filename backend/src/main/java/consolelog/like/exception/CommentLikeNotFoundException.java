package consolelog.like.exception;


import consolelog.global.advice.NotFoundException;
import consolelog.global.error.ErrorCode;

public class CommentLikeNotFoundException extends NotFoundException {


    public CommentLikeNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND_ERROR);
    }
}
