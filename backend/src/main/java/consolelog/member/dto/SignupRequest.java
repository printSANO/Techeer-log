package consolelog.member.dto;

import lombok.Getter;

@Getter
public class SignupRequest {

    private String email;
    private String username;

    private String password;
    private String passwordConfirmation;

    public SignupRequest() {
    }

    public SignupRequest(String email, String username, String password, String passwordConfirmation) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }
}
