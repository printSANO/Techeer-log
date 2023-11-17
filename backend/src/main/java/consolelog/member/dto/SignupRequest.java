package consolelog.member.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SignupRequest {

    private String loginId;
    private String nickname;
    private String password;
    private String passwordConfirmation;

    public SignupRequest() {
    }

    public SignupRequest(String loginId, String password, String nickname, String passwordConfirmation) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.passwordConfirmation = passwordConfirmation;
    }

}
