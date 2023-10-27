package consolelog.member.domain;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;

    @Embedded
    private LoginID loginID;

    @Embedded
    private Password password;

    @Embedded
    private Nickname nickname;


    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.USER;

    public Member() {
    }


    @Builder
    public Member(Long id, LoginID loginID, Password password, Nickname nickname) {
        this.id = id;
        this.loginID = loginID;
        this.password = password;
        this.nickname = nickname;
    }


    public void updateNickname(Nickname nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname.getValue();
    }

    public String getLoginID() {
        return loginID.getValue();
    }

    public String getPassword() {
        return password.getValue();
    }

}



