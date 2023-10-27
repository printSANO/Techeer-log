package consolelog.config;

import consolelog.support.AuthInterceptor;
import consolelog.support.token.TokenManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private static final String ALLOW_METHOD_NAMES = "GET,HEAD,POST,DELETE,TRACE,OPTIONS,PATCH,PUT";

    private final AuthInterceptor authInterceptor;
    private final TokenManager tokenManager;

    public WebMvcConfig(AuthInterceptor authInterceptor, TokenManager tokenManager) {
        this.authInterceptor = authInterceptor;
        this.tokenManager = tokenManager;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // CORS 설정을 모든 URL에 적용
                .allowedOrigins("http://console-log.com",       // 혀용할 도메인 목록
                        "https://console-log.com")
                .allowedMethods(ALLOW_METHOD_NAMES.split(","))  // 허용할 HTTP Method 목록
                .allowedHeaders("*")        // 모든 HTTP header 허용
                .allowCredentials(true)     // 자격 증명 허용
                .exposedHeaders(HttpHeaders.LOCATION, HttpHeaders.AUTHORIZATION, "Refresh-Token");  // 클라이언트에 노출할 헤더 목록
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/refresh");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(authenticationPrincipalArgumentResolver());
    }

    @Bean
    public AuthenticationPrincipalArgumentResolver authenticationPrincipalArgumentResolver() {
        return new AuthenticationPrincipalArgumentResolver(tokenManager);
    }
}
