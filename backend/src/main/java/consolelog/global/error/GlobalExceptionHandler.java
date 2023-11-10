package consolelog.global.error;

import consolelog.global.advice.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleRuntimeException(BusinessException e) {
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response =
                ErrorResponse.builder()
                        .code(errorCode.getCode())
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build();

        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }
}
