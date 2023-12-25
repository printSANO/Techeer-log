package consolelog.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import consolelog.auth.service.AuthService;
import consolelog.auth.service.RefreshTokenService;
import consolelog.global.support.token.TokenManager;
import consolelog.helper.ControllerTestHelper;
import consolelog.util.fixture.AuthFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static consolelog.util.fixture.AuthFixture.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = AuthController.class)
class AuthControllerTest extends ControllerTestHelper {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthService authService;

    @MockBean
    private RefreshTokenService refreshTokenService;

    @Test
    @DisplayName("아이디와 비밀번호를 입력하여 로그인을 한다.")
    void login() throws Exception {
        // given
        given(authService.login(any()))
                .willReturn(VALID_AUTH_INFO);

        // when // then
        mockMvc.perform(
            post("/api/v1/auth/login")
                .content(objectMapper.writeValueAsString(VALID_LOGIN_REQUEST))
                .contentType(MediaType.APPLICATION_JSON)

        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.AUTHORIZATION, "Bearer null"))
                .andExpect(header().string("Refresh-Token", "Bearer null"))
                .andExpect(jsonPath("$.code").value("A001"))
                ;

    }

    @Test
    void refresh() {
    }

    @Test
    void logout() {
    }
}