package consolelog.auth.service;

import consolelog.auth.domain.RefreshToken;
import consolelog.auth.dto.AuthInfo;
import consolelog.auth.exception.LoginFailedException;
import consolelog.auth.repository.RefreshTokenRepository;
import consolelog.global.support.token.InvalidRefreshTokenException;
import consolelog.global.support.token.TokenManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static consolelog.util.fixture.AuthFixture.*;
import static consolelog.util.fixture.MemberFixture.M1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@SpringBootTest
class RefreshTokenServiceTest {
    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @MockBean
    private TokenManager tokenManager;

    @AfterEach
    void tearDown() {
        refreshTokenRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("Refresh Token 을 DB 에 저장한다")
    void saveToken() {
        // given
        refreshTokenRepository.save(VALID_REFRESH_TOKEN);

        // when
        refreshTokenService.saveToken(VALID_REFRESH_TOKEN_STRING, 1L);

        // then
        assertThat(refreshTokenRepository.findRefreshTokenByMemberId(1L)).isNotEmpty();

    }

    @Test
    @DisplayName("입력 받은 Refresh Token 의 유효성을 검증한다")
    void matches() {
        // given
        given(tokenManager.isValid(VALID_REFRESH_TOKEN_STRING))
                .willReturn(true);
        refreshTokenRepository.save(VALID_REFRESH_TOKEN);

        // when
        refreshTokenService.matches(VALID_REFRESH_TOKEN_STRING, 1L);

        // then
    }

    @Test
    @DisplayName("입력 받은 Refresh Token 과 다른 아이디를 넣으면 오류가 발생한다")
    void matches_invalid() {
        // given
        given(tokenManager.isValid(VALID_REFRESH_TOKEN_STRING))
                .willReturn(true);
        refreshTokenRepository.save(VALID_REFRESH_TOKEN);

        // when  // then
        // Token 에 해당하는 memberId 1L 이 아닌, 2L을 넣었을 때, Exception이 발생
        assertThatThrownBy(() -> refreshTokenService.matches(VALID_REFRESH_TOKEN_STRING, 2L))
                .isInstanceOf(InvalidRefreshTokenException.class);
    }

    @Test
    @DisplayName("DB에 있는 Refresh Token 을 삭제한다")
    void deleteToken() {
        // given
        refreshTokenRepository.save(VALID_REFRESH_TOKEN);

        // when
        refreshTokenService.deleteToken(1L);

        // then
        assertThat(refreshTokenRepository.findRefreshTokenByMemberId(1L)).isEmpty();
    }
}