package consolelog.support.token;

import consolelog.advice.UnauthorizedException;

public class InvalidRefreshTokenException extends UnauthorizedException {
    private static final String MESSAGE = "유효하지 않은 토큰입니다.";

    public InvalidRefreshTokenException() {
        super(MESSAGE);
    }
}
