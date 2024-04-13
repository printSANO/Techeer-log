package consolelog.project.dto;

import consolelog.project.domain.Project;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface ProjectMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProjectFromRequest(ProjectRequest projectRequest, @MappingTarget Project project);
    Project projectRequestToProject(ProjectRequest projectRequest);
    ProjectRequest projectToProjectRequest(Project project);

    Project projectResponseToProject(ProjectResponse projectResponse);
    ProjectResponse projectToProjectResponse(Project project);
}
