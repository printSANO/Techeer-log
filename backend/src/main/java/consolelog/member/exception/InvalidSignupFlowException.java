package consolelog.member.exception;

public class InvalidSignupFlowException extends BadRequestException {

    private static final String MESSAGE = "비정상적인 회원가입 절차입니다.";

    public InvalidSignupFlowException() {
        super(MESSAGE);
    }
}
