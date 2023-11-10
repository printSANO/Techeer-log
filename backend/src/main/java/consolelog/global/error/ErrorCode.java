package consolelog.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Global
    INTERNAL_SERVER_ERROR( "G001", 500, "서버오류"),

    // Auth

    // Member

    // Post

    // Comment

    // Like


    ;

    private final String code;
    private final int status;
    private final String message;
}
