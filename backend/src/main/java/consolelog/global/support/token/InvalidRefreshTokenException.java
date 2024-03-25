package consolelog.global.support.token;

import consolelog.global.exception.UnauthorizedException;
import consolelog.global.response.ErrorCode;

public class InvalidRefreshTokenException extends UnauthorizedException {

    public InvalidRefreshTokenException() {
        super(ErrorCode.INVALID_REFRESH_TOKEN_ERROR);
    }
}
