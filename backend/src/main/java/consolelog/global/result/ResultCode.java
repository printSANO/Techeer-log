package consolelog.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    // Auth
    LOGIN_SUCCESS("A001", "200", "로그인 성공"),


    // Member
    SIGNUP_SUCCESS("M001", "201", "회원가입 성공"),
    FINDNICK_SUCCESS("MOO2", "200", "닉네임 조회 성공")
    // Post


    // Comment


    ;

    private final String code;
    private final String status;
    private final String message;
}
