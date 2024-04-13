package consolelog.project.dto;

import consolelog.project.domain.Project;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper {
    Project projectRequestToProject(ProjectRequest projectRequest);
    ProjectRequest projectToProjectRequest(Project project);

    Project projectResponseToProject(ProjectResponse projectResponse);
    ProjectResponse projectToProjectResponse(Project project);
}
