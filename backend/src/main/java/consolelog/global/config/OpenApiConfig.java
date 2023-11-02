package consolelog.global.config;

import consolelog.global.support.token.Login;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Console-log API Document")
                .version("v1")
                .description("Console-log API 문서");


        String accessToken = "accessToken";
        String refreshToken = "refreshToken";

        // API 요청헤더에 인증정보 포함
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(accessToken, refreshToken);


        // SecuritySchemes 등록
        Components components = new Components()
                .addSecuritySchemes(accessToken,
                        new SecurityScheme()
                                .name(accessToken)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("Bearer")
                                .bearerFormat("JWT"))
                .addSecuritySchemes(refreshToken,
                        new SecurityScheme()
                                .name(refreshToken)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("Bearer")
                                .bearerFormat("JWT"));


        SpringDocUtils.getConfig().addAnnotationsToIgnore(Login.class);

        return new OpenAPI().info(info).addSecurityItem(securityRequirement).components(components);
    }
}
