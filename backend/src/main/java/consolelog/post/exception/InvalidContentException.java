package consolelog.post.exception;

import consolelog.global.advice.BadRequestException;

public class InvalidContentException extends BadRequestException {
    private static final String MESSAGE = "내용은 1글자 이상 1000글자 이하 입니다.";

    public InvalidContentException() {
        super(MESSAGE);
    }
}
