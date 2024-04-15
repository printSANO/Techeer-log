package consolelog.member.domain;

import consolelog.auth.domain.RefreshToken;
import consolelog.global.config.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
public class Member extends BaseEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Embedded
    @Column(name = "login_id")
    private LoginId loginId;

    @Embedded
    private Password password;

    @Embedded
    private Nickname nickname;

    @Getter
    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Getter
    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.USER;

    @OneToOne(mappedBy = "member")
    private RefreshToken refreshToken;

    public String getLoginId() {
        return loginId.getValue();
    }

    public String getNickname() {
        return nickname.getValue();
    }

    public String getPassword() {
        return password.getValue();
    }

    public Member() {
    }


    @Builder
    public Member(Long id, LoginId loginId, Password password, Nickname nickname, String profileImageUrl) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public void updateNickname(Nickname nickname) {
        this.nickname = nickname;
    }

    public void updateProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public void updatePassword(Password password) {
        this.password = password;
    }

    public boolean hasId(Long id) {
        return this.id.equals(id);
    }
}



