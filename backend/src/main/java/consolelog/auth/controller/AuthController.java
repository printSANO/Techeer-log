package consolelog.auth.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.auth.dto.LoginRequest;
import consolelog.auth.service.AuthService;
import consolelog.auth.service.RefreshTokenService;
import consolelog.support.token.TokenManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;
    private final TokenManager tokenManager;
    private final RefreshTokenService refreshTokenService;

    public AuthController(AuthService authService, TokenManager tokenManager, RefreshTokenService refreshTokenService) {
        this.authService = authService;
        this.tokenManager = tokenManager;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest loginRequest) {
        AuthInfo authInfo = authService.login(loginRequest);
        String accessToken = tokenManager.createAccessToken(authInfo);
        String refreshToken = tokenManager.createRefreshToken();
        refreshTokenService.saveToken(refreshToken, authInfo.getId());

        // 200을 보냄
        // Authorization: Bearer accessToken
        // Refresh-Token: Bearer refreshToken
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .header("Refresh-Token", "Bearer " + refreshToken)
                .build();
    }

}
