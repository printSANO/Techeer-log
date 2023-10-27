package consolelog.member.domain;

import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;

    @Embedded
    private Username username;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    @Embedded
    private Nickname nickname;


    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.;

    public Member() {
    }


    @Builder
    public Member(Username username, Password password, Email email, Nickname nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }

    public void updateNickname(Nickname nickname) {
        this.nickname = nickname;
    }

    public static Member applicant(Username username, Password password, Nickname nickname, Email email) {
        Member member = new Member(username, password, email, nickname);
        member.roleType = RoleType.APPLICANT;
        return member;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email.getValue();
    }

    public String getNickname() {
        return nickname.getValue();
    }

    public String getUsername() {
        return username.getValue();
    }

    public String getPassword() {
        return password.getValue();
    }

}



