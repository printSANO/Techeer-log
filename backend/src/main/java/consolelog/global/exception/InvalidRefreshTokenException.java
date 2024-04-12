package consolelog.global.exception;

import consolelog.global.exception.BusinessException;
import consolelog.global.response.ErrorCode;

public class InvalidRefreshTokenException extends BusinessException {

    public InvalidRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN_ERROR);
    }
}
