package consolelog.member.dto;

import lombok.Getter;

@Getter
public class EmailRequest {

    @NotBlank
    private String email;

    public EmailRequest() {
    }

    public EmailRequest(String email) {
        this.email = email;
    }
}
