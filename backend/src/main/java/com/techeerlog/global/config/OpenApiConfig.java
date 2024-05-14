package com.techeerlog.global.config;

import com.techeerlog.global.support.token.Login;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.techeerlog.global.support.ConstantString.ACCESS_TOKEN_STRING;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Console-log API Document")
                .version("v1")
                .description("Console-log API 문서");


        String accessToken = ACCESS_TOKEN_STRING;

        // API 요청헤더에 인증정보 포함
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(accessToken);


        // SecuritySchemes 등록
        Components components = new Components()
                .addSecuritySchemes(accessToken,
                        new SecurityScheme()
                                .name(accessToken)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("Bearer")
                                .bearerFormat("JWT"));


        // Ignore 할 annotation 등록
        SpringDocUtils.getConfig().addAnnotationsToIgnore(Login.class);

        return new OpenAPI().info(info).addSecurityItem(securityRequirement).components(components);
    }
}
