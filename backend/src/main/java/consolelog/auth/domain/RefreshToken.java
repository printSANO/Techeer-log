package consolelog.auth.domain;

import consolelog.support.token.InvalidRefreshTokenException;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;

@Entity
@Getter
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refresh_token_id")
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "token")
    private String token;

    // @Entity 와 @Embedded 는 기본 생성자가 필요하다
    protected RefreshToken() {
    }

    public RefreshToken(Long memberId, String token) {
        this.memberId = memberId;
        this.token = token;
    }

    public void validateSameToken(String token) {
        if (!this.token.equals(token))
            throw new InvalidRefreshTokenException();
    }
}
