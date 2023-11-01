package consolelog.auth.exception;

import consolelog.advice.ForbiddenException;

public class AuthorizationException extends ForbiddenException {
<<<<<<< HEAD
=======

>>>>>>> #8
    private static final String MESSAGE = "권한이 없습니다.";

    public AuthorizationException() {
        super(MESSAGE);
    }

    public AuthorizationException(String message) {
        super(message);
    }
}
