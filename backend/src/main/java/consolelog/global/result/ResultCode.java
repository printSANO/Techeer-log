package consolelog.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    // Auth


    // Member


    // Post


    // Comment


    private final String code;
    private final String status;
    private final String message;
}
