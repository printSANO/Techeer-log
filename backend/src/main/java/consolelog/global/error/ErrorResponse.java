package consolelog.global.error;

import com.fasterxml.jackson.annotation.JsonCreator;
import consolelog.global.result.ResultCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Builder
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
