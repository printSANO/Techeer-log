package consolelog.auth.domain;

import consolelog.global.exception.InvalidRefreshTokenException;
import consolelog.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refresh_token_id")
    private Long id;

    @Column(name = "token")
    private String token;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // @Entity 와 @Embedded 는 기본 생성자가 필요하다
    protected RefreshToken() {
    }

    public RefreshToken(Long memberId, String token) {
        // 수정 필요
        // this.member = memberId;
        this.token = token;
    }

    public void validateSameToken(String token) {
        if (!this.token.equals(token))
            throw new InvalidRefreshTokenException();
    }
}
