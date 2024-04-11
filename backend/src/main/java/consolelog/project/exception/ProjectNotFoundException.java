package consolelog.project.exception;

import consolelog.global.exception.BusinessException;
import consolelog.global.response.ErrorCode;

public class ProjectNotFoundException extends BusinessException {

    public ProjectNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND_ERROR);
    }
}
