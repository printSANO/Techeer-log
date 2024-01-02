package consolelog.auth.repository;

import consolelog.auth.domain.RefreshToken;
import consolelog.global.support.token.InvalidRefreshTokenException;
import consolelog.util.fixture.AuthFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Ref;
import java.util.Optional;

import static consolelog.util.fixture.AuthFixture.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class RefreshTokenRepositoryTest {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @AfterEach
    void tearDown() {
        refreshTokenRepository.deleteAllInBatch();
    }

    @Test
    @Transactional
    @DisplayName("DB에 token이 저장된다")
    void save() {
        // given
        // VALID_REFRESH_TOKEN

        // when
        RefreshToken savedToken = refreshTokenRepository.save(VALID_REFRESH_TOKEN);

        // then
        assertThat(savedToken).isEqualTo(VALID_REFRESH_TOKEN);
    }

    @Test
    @Transactional
    @DisplayName("DB에 저장된 Token을 memberId로 가져올 수 있다")
    public void findRefreshTokenByMemberId() throws Exception {
        //given
        RefreshToken savedToken = refreshTokenRepository.save(VALID_REFRESH_TOKEN);

        //when
        RefreshToken findToken = refreshTokenRepository.findRefreshTokenByMemberId(1L)
                .orElseThrow(Exception::new);

        //then
        assertThat(findToken).isEqualTo(savedToken);
    }

    @Test
    @Transactional
    @DisplayName("DB에 저장된 Token을 memberId로 삭제할 수 있다")
    public void deleteAllByMemberId() throws Exception {
        //given
        RefreshToken savedToken = refreshTokenRepository.save(VALID_REFRESH_TOKEN);

        //when
        refreshTokenRepository.deleteAllByMemberId(1L);

        //then
        assertThat(refreshTokenRepository.findRefreshTokenByMemberId(1L)).isEmpty();
    }
}