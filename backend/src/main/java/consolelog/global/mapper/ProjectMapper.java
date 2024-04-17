package consolelog.global.mapper;

import consolelog.project.domain.Project;
import consolelog.project.dto.ProjectRequest;
import consolelog.project.dto.ProjectResponse;
import org.mapstruct.*;

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

    List<ProjectResponse> projectListToProjectResponseList(List<Project> projects);
}
