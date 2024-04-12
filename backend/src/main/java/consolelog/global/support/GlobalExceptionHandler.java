package consolelog.global.support;

import consolelog.global.exception.BusinessException;
import consolelog.global.response.ErrorCode;
import consolelog.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.Arrays;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //    @Log4j2 어노테이션으로 대체가 가능하다
    //    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);
    //    객체명은 log 로 자동 생성된다
    @Order(0)
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = new ErrorResponse(errorCode);

//        [ Error Level ]
//        trace < debug < info < warn < error
//        현재 logging level 은 info 로 설정되어, info, warn, error 만 로그에 남는다

//        log.trace(e.toString());
//        log.debug(e.toString());
//        log.info(e.toString());
//        log.warn(e.toString());
        log.error(e.toString());

        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    @Order(1)
    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {

        log.error(ErrorCode.INTERNAL_SERVER_ERROR + ", " + Arrays.toString(e.getStackTrace()));

        final ErrorResponse response = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR);

        return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus()).body(response);
    }

    @Order(2)
    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {

        log.error(e + ", " + Arrays.toString(e.getStackTrace()));

        final ErrorResponse response = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR);

        return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus()).body(response);
    }
}
