package consolelog.global.support.token;

import consolelog.global.advice.UnauthorizedException;
import consolelog.global.error.ErrorCode;

public class InvalidRefreshTokenException extends UnauthorizedException {

    public InvalidRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN_ERROR);
    }
}
