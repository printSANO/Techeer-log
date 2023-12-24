package consolelog.auth.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.auth.exception.LoginFailedException;
import consolelog.global.advice.BadRequestException;
import consolelog.member.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static consolelog.util.fixture.AuthFixture.*;
import static consolelog.util.fixture.MemberFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class AuthServiceTest {

    @Autowired
    private AuthService authService;
    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    void tearDown() {
        memberRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("생성되어 있는 Member의 Password 와 Id를 입력하여 로그인에 성공한다.")
    void login_success() {
        // given
        memberRepository.save(M1);

        // when
        AuthInfo authInfo = authService.login(VALID_LOGIN_REQUEST);

        // then
        assertThat(authInfo.getId()).isNotNull();
    }

    @Test
    @DisplayName("Member의 ID 또는 Password를 잘못 입력하면, 로그인에 실패한다.")
    void login_fail() {
        // given
        memberRepository.save(M1);

        // then
        // Password 만 틀렸을 때
        assertThatThrownBy(() -> authService.login(INVALID_LOGIN_REQUEST_1))
                .isInstanceOf(LoginFailedException.class);

        // ID 가 존재하지 않을 때
        assertThatThrownBy(() -> authService.login(INVALID_LOGIN_REQUEST_2))
                .isInstanceOf(LoginFailedException.class);
    }
}