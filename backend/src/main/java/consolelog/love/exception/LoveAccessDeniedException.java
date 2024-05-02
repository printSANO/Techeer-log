package consolelog.love.exception;

import consolelog.global.exception.BusinessException;
import consolelog.global.response.ErrorCode;

public class LoveAccessDeniedException extends BusinessException {
    public LoveAccessDeniedException() {
        super(ErrorCode.AUTHORIZED_ERROR);
    }

}
