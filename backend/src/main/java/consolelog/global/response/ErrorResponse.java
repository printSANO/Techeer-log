package consolelog.global.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import consolelog.global.response.ErrorCode;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private final String code;
    private final int status;
    private final String message;


    @JsonCreator
    public ErrorResponse(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }
}
