package consolelog.auth.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.auth.dto.LoginRequest;
import consolelog.auth.service.AuthService;
import consolelog.auth.service.RefreshTokenService;
import consolelog.global.result.ResultResponse;
import consolelog.global.support.token.AuthorizationExtractor;
import consolelog.global.support.token.Login;
import consolelog.global.support.token.TokenManager;
import consolelog.global.support.token.TokenNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static consolelog.global.result.ResultCode.*;

@Tag(name = "Auth", description = "Auth API Document")
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthService authService;
    private final TokenManager tokenManager;
    private final RefreshTokenService refreshTokenService;

    public AuthController(AuthService authService, TokenManager tokenManager, RefreshTokenService refreshTokenService) {
        this.authService = authService;
        this.tokenManager = tokenManager;
        this.refreshTokenService = refreshTokenService;
    }

    @Operation(summary = "로그인", description = "로그인 기능")
    @PostMapping("/login")
    public ResponseEntity<ResultResponse<String>> login(@Valid @RequestBody LoginRequest loginRequest) {
        AuthInfo authInfo = authService.login(loginRequest);
        String accessToken = tokenManager.createAccessToken(authInfo);
        String refreshToken = tokenManager.createRefreshToken();
        refreshTokenService.saveToken(refreshToken, authInfo.getId());

        ResultResponse<String> resultResponse = new ResultResponse<>(LOGIN_SUCCESS);

        // 200을 보냄
        // Authorization: Bearer accessToken
        // Refresh-Token: Bearer refreshToken
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .header("Refresh-Token", "Bearer " + refreshToken)
                .body(resultResponse);
    }

    @Operation(summary = "토큰 재발급", description = "accessToken 을 재생성")
    @GetMapping("/refresh")
    public ResponseEntity<ResultResponse<String>> refresh(@RequestHeader("Refresh-Token") String refresh_token, HttpServletRequest request, @Login AuthInfo authInfo) {
        validateExistHeader(request);
        Long memberId = authInfo.getId();
        // extract : 뽑아내다. request에서 RefreshToken을 뽑아내는 과정
        String refreshToken = AuthorizationExtractor.extractRefreshToken(request);

        // memberId와 토큰 정보가 다르면, error 를 throw 한다
        refreshTokenService.matches(refreshToken, memberId);

        String accessToken = tokenManager.createAccessToken(authInfo);

        ResultResponse<String> resultResponse = new ResultResponse<>(REFRESH_SUCCESS);

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .body(resultResponse);
    }

    @Operation(summary = "로그아웃", description = "로그아웃 기능")
    @GetMapping("/logout")
    public ResponseEntity<ResultResponse<String>> logout(@Login AuthInfo authInfo) {
        refreshTokenService.deleteToken(authInfo.getId());
        ResultResponse<String> resultResponse = new ResultResponse<>(LOGOUT_SUCCESS);
        return ResponseEntity.ok().body(resultResponse);
    }

    private void validateExistHeader(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        String refreshTokenHeader = request.getHeader("Refresh-Token");
        if (Objects.isNull(authorizationHeader) || Objects.isNull(refreshTokenHeader))
            throw new TokenNotFoundException();
    }

}