package consolelog.member.domain;

import consolelog.global.config.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
public class Member extends BaseEntity {

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
    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.USER;

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
    public Member(Long id, LoginId loginId, Password password, Nickname nickname) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void updateNickname(Nickname nickname) {
        this.nickname = nickname;
    }

    public boolean hasId(Long id) {
        return this.id.equals(id);
    }
}



