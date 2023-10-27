package consolelog.member.dto;

import lombok.Getter;

@Getter
public class SignupRequest {

    private String email;
    private String loginID;
    private String nickname;
    private String password;

    public SignupRequest() {
    }

    public SignupRequest(String email, String loginID, String password, String nickname) {
        this.email = email;
        this.loginID = loginID;
        this.password = password;
        this.nickname = nickname;
    }

}
