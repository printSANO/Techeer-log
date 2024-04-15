package consolelog.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditMemberRequest {

    private String nickname;
    private String password;
    private String profileImageUrl;

}
