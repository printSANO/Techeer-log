package consolelog.global.mapper;

import consolelog.member.domain.Member;
import consolelog.member.dto.MemberResponse;
import consolelog.project.domain.Project;
import consolelog.project.dto.ProjectItemResponse;
import consolelog.project.dto.ProjectRequest;
import consolelog.project.dto.ProjectResponse;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProjectFromRequest(ProjectRequest projectRequest, @MappingTarget Project project);
    Project projectRequestToProject(ProjectRequest projectRequest);
    ProjectRequest projectToProjectRequest(Project project);

    Project projectResponseToProject(ProjectResponse projectResponse);

    ProjectResponse projectToProjectResponse(Project project);

    ProjectItemResponse projectToProjectItemResponse(Project project);
}
