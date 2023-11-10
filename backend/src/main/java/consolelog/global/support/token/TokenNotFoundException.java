package consolelog.global.support.token;

import consolelog.global.advice.UnauthorizedException;
import consolelog.global.error.ErrorCode;

public class TokenNotFoundException extends UnauthorizedException {

    public TokenNotFoundException() {
        super(ErrorCode.TOKEN_NOT_FOUND_ERROR);
    }
}
