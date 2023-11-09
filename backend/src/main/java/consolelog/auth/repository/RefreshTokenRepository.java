package consolelog.auth.repository;

import consolelog.auth.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findRefreshTokenByMemberId(Long memberId);

    public void deleteAllByMemberId(Long memberId);
}
