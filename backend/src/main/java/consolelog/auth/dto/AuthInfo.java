package consolelog.auth.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class AuthInfo {

    private Long id;
    private String type;
    private String nickname;

    public AuthInfo(Long id, String type, String nickname) {
        this.id = id;
        this.type = type;
        this.nickname = nickname;
    }
}
