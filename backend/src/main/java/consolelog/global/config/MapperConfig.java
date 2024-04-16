package consolelog.global.config;

import consolelog.framework.dto.FrameworkMapper;
import consolelog.framework.dto.FrameworkMapperImpl;
import consolelog.member.dto.MemberMapper;
import consolelog.member.dto.MemberMapperImpl;
import consolelog.project.dto.ProjectMapper;
import consolelog.project.dto.ProjectMapperImpl;
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
