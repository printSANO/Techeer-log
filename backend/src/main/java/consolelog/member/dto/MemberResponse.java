package consolelog.member.dto;

import consolelog.member.domain.LoginId;
import consolelog.member.domain.Member;
import consolelog.member.domain.Nickname;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {
    private Long id;
    private String loginId;
    private String nickname;
    private String profileImageUrl;
}
