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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static consolelog.global.result.ResultCode.*;
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
        given(authService.login(VALID_LOGIN_REQUEST))
                .willReturn(VALID_AUTH_INFO);

        MockHttpServletRequestBuilder mockPost = post("/api/v1/auth/login")
                .content(objectMapper.writeValueAsString(VALID_LOGIN_REQUEST))
                .contentType(MediaType.APPLICATION_JSON);

        // when // then
        mockMvc.perform(mockPost)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.AUTHORIZATION, "Bearer null"))
                .andExpect(header().string("Refresh-Token", "Bearer null"))
                .andExpect(jsonPath("$.code").value(LOGIN_SUCCESS.getCode()))
                .andExpect(jsonPath("$.message").value(LOGIN_SUCCESS.getMessage()))
                ;
    }

    @Test
    @DisplayName("request로 받은 user와 refreshToken이 DB에 저장되어 있는 값과 비교하여 일치하는 지 확인한다.")
    void refresh() throws Exception {
        // given
        given(tokenManager.createAccessToken(VALID_AUTH_INFO))
                .willReturn(VALID_REFRESHED_ACCESS_TOKEN);

        MockHttpServletRequestBuilder getMock = get("/api/v1/auth/refresh")
                .header(HttpHeaders.AUTHORIZATION, VALID_ACCESS_TOKEN)
                .header("Refresh-Token", VALID_REFRESH_TOKEN);

        // when // then
        mockMvc.perform(getMock)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.AUTHORIZATION, VALID_REFRESHED_ACCESS_TOKEN))
                .andExpect(jsonPath("$.code").value(REFRESH_SUCCESS.getCode()))
                .andExpect(jsonPath("$.message").value(REFRESH_SUCCESS.getMessage()))
        ;
    }

    @Test
    @DisplayName("Auth Info 에서 받은 id 값을 통해 logout이 동작하는 것을 확인한다")
    void logout() throws Exception {
        // given
        MockHttpServletRequestBuilder getMock = get("/api/v1/auth/logout")
                .header(HttpHeaders.AUTHORIZATION, VALID_ACCESS_TOKEN);

        // when // then
        mockMvc.perform(getMock)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(LOGOUT_SUCCESS.getCode()))
                .andExpect(jsonPath("$.message").value(LOGOUT_SUCCESS.getMessage()))
        ;
    }
}