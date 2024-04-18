package consolelog.framework.exception;

import consolelog.global.exception.BusinessException;
import consolelog.global.response.ErrorCode;

public class FrameworkNotFoundException extends BusinessException {
    public FrameworkNotFoundException() {
        super(ErrorCode.FRAMEWORK_NOT_FOUND_ERROR);
    }
}
