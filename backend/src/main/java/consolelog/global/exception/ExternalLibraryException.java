package consolelog.global.exception;

import consolelog.global.response.ErrorCode;

public class ExternalLibraryException extends BusinessException {

    public ExternalLibraryException() {
        super(ErrorCode.EXTERNAL_LIBRARY_ERROR);
    }
}
