package consolelog.project.exception;

import consolelog.global.exception.BusinessException;
import consolelog.global.response.ErrorCode;

public class PageableAccessException extends BusinessException {

    public PageableAccessException() {
        super(ErrorCode.PAGEABLE_ACCESS_ERROR);
    }
}
