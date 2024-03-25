package consolelog.global.support.token;

import consolelog.global.exception.UnauthorizedException;
import consolelog.global.response.ErrorCode;

public class TokenNotFoundException extends UnauthorizedException {

    public TokenNotFoundException() {
        super(ErrorCode.TOKEN_NOT_FOUND_ERROR);
    }
}
