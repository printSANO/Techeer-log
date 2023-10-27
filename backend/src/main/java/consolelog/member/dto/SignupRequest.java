package consolelog.member.dto;

import lombok.Getter;

@Getter
public class SignupRequest {

    private String email;
    private String username;
    private String nickname;
    private String password;

    public SignupRequest() {
    }

    public SignupRequest(String email, String username, String password, String nickname) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

}
