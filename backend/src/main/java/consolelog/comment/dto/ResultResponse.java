package consolelog.comment.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import consolelog.result.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResultResponse<T> {

    private final String status;
    private final String message;
    private Object data;

    @JsonCreator
    public ResultResponse(ResultCode resultCode) {
        this.status = resultCode.getStatus();
        this.message = resultCode.getMessage();
    }
}



