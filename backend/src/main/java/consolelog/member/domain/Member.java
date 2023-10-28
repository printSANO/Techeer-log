package consolelog.member.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    @Getter
    private long id;

    @Embedded
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


    public void updateNickname(Nickname nickname) {
        this.nickname = nickname;
    }

}



