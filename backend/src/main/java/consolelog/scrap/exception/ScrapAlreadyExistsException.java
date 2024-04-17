package consolelog.scrap.exception;

public class ScrapAlreadyExistsException extends RuntimeException{
    public ScrapAlreadyExistsException() {
        super("이미 스크랩한 프로젝트입니다.");
    }
    public ScrapAlreadyExistsException(String message) {
        super(message);
    }
}
