package consolelog.member.dto;

import lombok.Getter;

@Getter
public class SignupRequest {

    private String email;
    private String loginID;
    private String nickname;
    private String password;
    private String passwordConfirmation;

    public SignupRequest() {
    }

    public SignupRequest(String email, String loginID, String password, String nickname, String passwordConfirmation) {
        this.email = email;
        this.loginID = loginID;
        this.password = password;
        this.nickname = nickname;
        this.passwordConfirmation = passwordConfirmation;
    }

}
