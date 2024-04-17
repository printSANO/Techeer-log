package consolelog.scrap.exception;

import consolelog.global.exception.BusinessException;
import consolelog.global.response.ErrorCode;

public class ScrapNotFoundException extends BusinessException {
    public ScrapNotFoundException() {
        super(ErrorCode.SCRAP_NOT_FOUND_ERROR);
    }
}
