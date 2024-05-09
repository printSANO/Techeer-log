package consolelog.global.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class SimpleResultResponse {
    private final String code;
    private final String message;


    @JsonCreator
    public SimpleResultResponse(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }
}