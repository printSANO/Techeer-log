package consolelog.auth.exception;

import consolelog.advice.AnauthorizedException;

public class LoginFailedException extends AnauthorizedException {
    private static final String MESSAGE = "아이디나 비밀번호가 잘못되었습니다.";

    public LoginFailedException() {
        super(MESSAGE);
    }
}
