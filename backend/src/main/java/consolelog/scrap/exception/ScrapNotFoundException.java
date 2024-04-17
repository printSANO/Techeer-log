package consolelog.scrap.exception;

public class ScrapNotFoundException extends RuntimeException{
    public ScrapNotFoundException() {
        super("해당 스크랩을 찾을 수 없습니다.");
    }
    public ScrapNotFoundException(String message) {
        super(message);
    }
}
