package consolelog.scrap.exception;

import consolelog.global.exception.BusinessException;
import consolelog.global.response.ErrorCode;

public class ScrapAlreadyExistsException extends BusinessException {
    public ScrapAlreadyExistsException() {
        super(ErrorCode.SCRAP_DUPLICATE_ERROR);
    }
}
