package consolelog.auth.service;

import consolelog.auth.dto.AuthInfo;
import consolelog.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static consolelog.util.fixture.AuthFixture.*;
import static consolelog.util.fixture.MemberFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AuthServiceTest {

    @Autowired
    private AuthService authService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("로그인 기능")
    void login() {
        // given
        memberRepository.save(M1);

        // when
        AuthInfo authInfo = authService.login(VALID_LOGIN_REQUEST);

        // then
        assertThat(authInfo.getId()).isNotNull();
    }
    
}