package com.techeerlog.global.mapper;

import com.techeerlog.project.domain.Project;
import com.techeerlog.project.dto.ProjectItemResponse;
import com.techeerlog.project.dto.ProjectRequest;
import com.techeerlog.project.dto.ProjectResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-31T15:09:55+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public void updateProjectFromRequest(ProjectRequest projectRequest, Project project) {
        if ( projectRequest == null ) {
            return;
        }

        if ( projectRequest.getMainImageUrl() != null ) {
            project.setMainImageUrl( projectRequest.getMainImageUrl() );
        }
        if ( projectRequest.getTitle() != null ) {
            project.setTitle( projectRequest.getTitle() );
        }
        if ( projectRequest.getSubtitle() != null ) {
            project.setSubtitle( projectRequest.getSubtitle() );
        }
        if ( projectRequest.getContent() != null ) {
            project.setContent( projectRequest.getContent() );
        }
        if ( projectRequest.getStartDate() != null ) {
            project.setStartDate( projectRequest.getStartDate() );
        }
        if ( projectRequest.getEndDate() != null ) {
            project.setEndDate( projectRequest.getEndDate() );
        }
        if ( projectRequest.getPlatform() != null ) {
            project.setPlatform( projectRequest.getPlatform() );
        }
        if ( projectRequest.getProjectType() != null ) {
            project.setProjectType( projectRequest.getProjectType() );
        }
        project.setYear( projectRequest.getYear() );
        if ( projectRequest.getSemester() != null ) {
            project.setSemester( projectRequest.getSemester() );
        }
        if ( projectRequest.getProjectStatus() != null ) {
            project.setProjectStatus( projectRequest.getProjectStatus() );
        }
        if ( projectRequest.getGithubLink() != null ) {
            project.setGithubLink( projectRequest.getGithubLink() );
        }
        if ( projectRequest.getBlogLink() != null ) {
            project.setBlogLink( projectRequest.getBlogLink() );
        }
        if ( projectRequest.getWebsiteLink() != null ) {
            project.setWebsiteLink( projectRequest.getWebsiteLink() );
        }
    }

    @Override
    public Project projectRequestToProject(ProjectRequest projectRequest) {
        if ( projectRequest == null ) {
            return null;
        }

        Project project = new Project();

        project.setMainImageUrl( projectRequest.getMainImageUrl() );
        project.setTitle( projectRequest.getTitle() );
        project.setSubtitle( projectRequest.getSubtitle() );
        project.setContent( projectRequest.getContent() );
        project.setStartDate( projectRequest.getStartDate() );
        project.setEndDate( projectRequest.getEndDate() );
        project.setPlatform( projectRequest.getPlatform() );
        project.setProjectType( projectRequest.getProjectType() );
        project.setYear( projectRequest.getYear() );
        project.setSemester( projectRequest.getSemester() );
        project.setProjectStatus( projectRequest.getProjectStatus() );
        project.setGithubLink( projectRequest.getGithubLink() );
        project.setBlogLink( projectRequest.getBlogLink() );
        project.setWebsiteLink( projectRequest.getWebsiteLink() );

        return project;
    }

    @Override
    public ProjectRequest projectToProjectRequest(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectRequest projectRequest = new ProjectRequest();

        projectRequest.setTitle( project.getTitle() );
        projectRequest.setSubtitle( project.getSubtitle() );
        projectRequest.setContent( project.getContent() );
        projectRequest.setStartDate( project.getStartDate() );
        projectRequest.setEndDate( project.getEndDate() );
        projectRequest.setPlatform( project.getPlatform() );
        projectRequest.setProjectType( project.getProjectType() );
        projectRequest.setYear( project.getYear() );
        projectRequest.setSemester( project.getSemester() );
        projectRequest.setProjectStatus( project.getProjectStatus() );
        projectRequest.setGithubLink( project.getGithubLink() );
        projectRequest.setBlogLink( project.getBlogLink() );
        projectRequest.setWebsiteLink( project.getWebsiteLink() );
        projectRequest.setMainImageUrl( project.getMainImageUrl() );

        return projectRequest;
    }

    @Override
    public Project projectResponseToProject(ProjectResponse projectResponse) {
        if ( projectResponse == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectResponse.getId() );
        project.setMainImageUrl( projectResponse.getMainImageUrl() );
        project.setTitle( projectResponse.getTitle() );
        project.setSubtitle( projectResponse.getSubtitle() );
        project.setContent( projectResponse.getContent() );
        project.setStartDate( projectResponse.getStartDate() );
        project.setEndDate( projectResponse.getEndDate() );
        project.setPlatform( projectResponse.getPlatform() );
        project.setProjectType( projectResponse.getProjectType() );
        project.setYear( projectResponse.getYear() );
        project.setSemester( projectResponse.getSemester() );
        project.setProjectStatus( projectResponse.getProjectStatus() );
        project.setGithubLink( projectResponse.getGithubLink() );
        project.setBlogLink( projectResponse.getBlogLink() );
        project.setWebsiteLink( projectResponse.getWebsiteLink() );

        return project;
    }

    @Override
    public ProjectResponse projectToProjectResponse(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectResponse projectResponse = new ProjectResponse();

        projectResponse.setId( project.getId() );
        projectResponse.setMainImageUrl( project.getMainImageUrl() );
        projectResponse.setTitle( project.getTitle() );
        projectResponse.setSubtitle( project.getSubtitle() );
        projectResponse.setContent( project.getContent() );
        projectResponse.setStartDate( project.getStartDate() );
        projectResponse.setEndDate( project.getEndDate() );
        projectResponse.setPlatform( project.getPlatform() );
        projectResponse.setProjectType( project.getProjectType() );
        projectResponse.setYear( project.getYear() );
        projectResponse.setSemester( project.getSemester() );
        projectResponse.setProjectStatus( project.getProjectStatus() );
        projectResponse.setGithubLink( project.getGithubLink() );
        projectResponse.setBlogLink( project.getBlogLink() );
        projectResponse.setWebsiteLink( project.getWebsiteLink() );

        return projectResponse;
    }

    @Override
    public ProjectItemResponse projectToProjectItemResponse(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectItemResponse projectItemResponse = new ProjectItemResponse();

        projectItemResponse.setId( project.getId() );
        projectItemResponse.setMainImageUrl( project.getMainImageUrl() );
        projectItemResponse.setTitle( project.getTitle() );
        projectItemResponse.setSubtitle( project.getSubtitle() );
        projectItemResponse.setStartDate( project.getStartDate() );
        projectItemResponse.setEndDate( project.getEndDate() );
        projectItemResponse.setPlatform( project.getPlatform() );
        projectItemResponse.setProjectType( project.getProjectType() );
        projectItemResponse.setYear( project.getYear() );
        projectItemResponse.setSemester( project.getSemester() );
        projectItemResponse.setProjectStatus( project.getProjectStatus() );

        return projectItemResponse;
    }
}
