package consolelog.post.exception;

import consolelog.advice.BadRequestException;

public class InvalidTitleException extends BadRequestException {
    private static final String MESSAGE = "제목은 1글자 이상 50글자 이하 입니다.";

    public InvalidTitleException() {
        super(MESSAGE);
    }
}
