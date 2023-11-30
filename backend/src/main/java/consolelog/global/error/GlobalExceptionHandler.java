package consolelog.global.error;

import consolelog.global.advice.BusinessException;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @Log4j2 어노테이션으로 대체가 가능하다
//    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);
//    객체명은 log 로 자동 생성된다

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleRuntimeException(BusinessException e) {
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
}
