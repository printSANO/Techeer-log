package com.techeerlog.global.support;

import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;
import com.techeerlog.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.Arrays;

import static com.techeerlog.global.response.ErrorCode.INTERNAL_SERVER_ERROR;
import static com.techeerlog.global.response.ErrorCode.MAX_UPLOAD_SIZE_EXCEEDED_ERROR;


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
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    protected ResponseEntity<ErrorResponse> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        final ErrorCode errorCode = MAX_UPLOAD_SIZE_EXCEEDED_ERROR;
        final ErrorResponse response = new ErrorResponse(errorCode);

        log.error("{}, {}", errorCode, Arrays.toString(e.getStackTrace()));

        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    // IllegalArgumentException : Page size must not be less than one
    // NumberFormatException
    // MethodArgumentNotValidException
    @Order(2)
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        final ErrorCode errorCode = INTERNAL_SERVER_ERROR;
        final ErrorResponse response = new ErrorResponse(errorCode);

        log.error("{}, {}", errorCode, Arrays.toString(e.getStackTrace()));

        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }
}
