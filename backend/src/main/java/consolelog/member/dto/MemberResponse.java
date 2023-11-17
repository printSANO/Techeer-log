package consolelog.member.dto;

import consolelog.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponse {

    private String loginId;
    private String nickname;
    private String profileImageUrl;

    public MemberResponse() {
    }

    public MemberResponse(Member member) {
        this.loginId = member.getLoginId();
        this.nickname = member.getNickname();
        this.profileImageUrl = member.getProfileImageUrl();
    }
}
