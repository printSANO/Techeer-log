package com.techeerlog.global.config;

import com.techeerlog.global.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ProjectMapper projectMapper() {
        return new ProjectMapperImpl();
    }

    @Bean
    public MemberMapper memberMapper() {return new MemberMapperImpl();
    }

    @Bean
    public FrameworkMapper frameworkMapper() { return new FrameworkMapperImpl();
    }
}
