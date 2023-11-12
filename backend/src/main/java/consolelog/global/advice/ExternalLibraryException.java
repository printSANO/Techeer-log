package consolelog.global.advice;

import consolelog.global.error.ErrorCode;

public class ExternalLibraryException extends InternalException {

    public ExternalLibraryException() {
        super(ErrorCode.EXTERNAL_LIBRARY_ERROR);
    }
}
