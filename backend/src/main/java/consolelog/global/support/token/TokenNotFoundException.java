package consolelog.global.support.token;

import consolelog.global.exception.BusinessException;
import consolelog.global.response.ErrorCode;

public class TokenNotFoundException extends BusinessException {

    public TokenNotFoundException() {
        super(ErrorCode.TOKEN_NOT_FOUND_ERROR);
    }
}
