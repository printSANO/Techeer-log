package consolelog.member.dto;

import lombok.Getter;

@Getter
public class EditNicknameRequest {
    private String nickname;

    public EditNicknameRequest() {
    }

    public EditNicknameRequest(String nickname) {
        this.nickname = nickname;
    }
}
