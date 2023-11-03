package consolelog.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    // Auth
    LOGIN_SUCCESS("A001", "200", "로그인 성공"),
    REFRESH_SUCCESS("A002", "204", "access token 재발급 성공"),
    LOGOUT_SUCCESS("A003", "200", "로그아웃 성공"),

    // Member


    // Post


    // Comment


    ;

    private final String code;
    private final String status;
    private final String message;
}
