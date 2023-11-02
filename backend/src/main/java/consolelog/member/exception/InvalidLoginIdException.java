package consolelog.member.exception;

import consolelog.global.advice.BadRequestException;

public class InvalidLoginIdException extends BadRequestException {

    private static final String MESSAGE = "잘못된 아이디 형식입니다.";

    public InvalidLoginIdException() {
        super(MESSAGE);
    }
}
