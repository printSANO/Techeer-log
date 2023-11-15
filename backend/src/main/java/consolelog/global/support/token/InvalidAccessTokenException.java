package consolelog.global.support.token;

import consolelog.global.advice.UnauthorizedException;
import consolelog.global.error.ErrorCode;

public class InvalidAccessTokenException extends UnauthorizedException {

    public InvalidAccessTokenException() {
        super(ErrorCode.INVALID_ACCESS_TOKEN_ERROR);
    }
}
