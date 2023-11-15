package consolelog.comment.exception;

import consolelog.global.advice.BadRequestException;
import consolelog.global.error.ErrorCode;

public class ReplyDepthException extends BadRequestException {


    public ReplyDepthException() {
        super(ErrorCode.REPLY_DEPTH_ERROR);
    }
}
