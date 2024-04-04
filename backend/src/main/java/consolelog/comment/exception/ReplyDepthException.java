package consolelog.comment.exception;

import consolelog.global.response.ErrorCode;
import consolelog.global.exception.BusinessException;

public class ReplyDepthException extends BusinessException {


    public ReplyDepthException() {
        super(ErrorCode.REPLY_DEPTH_ERROR);
    }
}
