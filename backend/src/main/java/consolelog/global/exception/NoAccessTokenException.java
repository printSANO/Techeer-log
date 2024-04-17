package consolelog.global.exception;

import consolelog.global.response.ErrorCode;

public class NoAccessTokenException extends BusinessException {

    public NoAccessTokenException() {
        super(ErrorCode.NO_ACCESS_TOKEN_ERROR);
    }
}
