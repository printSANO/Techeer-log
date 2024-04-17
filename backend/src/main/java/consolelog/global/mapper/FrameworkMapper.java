package consolelog.global.mapper;

import consolelog.framework.domain.Framework;
import consolelog.framework.dto.FrameworkResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FrameworkMapper {
    FrameworkResponse frameworkToFrameworkResponse(Framework framework);
}
