package consolelog.member.exception;

public class InvalidUsernameException extends BadRequestException {

    private static final String MESSAGE = "잘못된 아이디 형식입니다.";

    public InvalidUsernameException() {
        super(MESSAGE);
    }
}
