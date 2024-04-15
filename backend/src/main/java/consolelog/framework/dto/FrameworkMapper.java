package consolelog.framework.dto;

import consolelog.framework.domain.Framework;
import org.mapstruct.Mapper;

@Mapper
public interface FrameworkMapper {
    FrameworkResponse frameworkToFrameworkResponse(Framework framework);
}
