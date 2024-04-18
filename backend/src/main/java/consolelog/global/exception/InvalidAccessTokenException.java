package consolelog.global.exception;

import consolelog.global.exception.BusinessException;
import consolelog.global.response.ErrorCode;

public class InvalidAccessTokenException extends BusinessException {

    public InvalidAccessTokenException() {
        super(ErrorCode.INVALID_ACCESS_TOKEN_ERROR);
    }
}
