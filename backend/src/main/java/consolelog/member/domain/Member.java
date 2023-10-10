package consolelog.member.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_Id")
    private long id;

    @Embedded
    private Username username;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    public Member() {

    }

    public Member(Long id, Username username, Password password, Email email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }


}
