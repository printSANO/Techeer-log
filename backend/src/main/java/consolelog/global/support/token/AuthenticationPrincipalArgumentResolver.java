package consolelog.global.support.token;

import consolelog.auth.dto.AuthInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

public class AuthenticationPrincipalArgumentResolver implements HandlerMethodArgumentResolver {
    private final TokenManager tokenManager;

    public AuthenticationPrincipalArgumentResolver(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Login.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String token = AuthorizationExtractor.extractAccessToken(Objects.requireNonNull(request));

        // AuthorizationExtractor 에서 null 에 대한 오류를 발생시킬 수는 없었을까? 왜 별도로 처리할까?
        if (token == null) {
            return new AuthInfo(null, null, null);
        }
        return tokenManager.getParsedClaims(token);
    }
}
