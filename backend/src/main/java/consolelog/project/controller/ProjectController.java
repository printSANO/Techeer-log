package consolelog.project.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.global.response.ResultResponse;
import consolelog.global.support.token.Login;
import consolelog.project.dto.ProjectItemResponse;
import consolelog.project.dto.ProjectListRequest;
import consolelog.project.dto.ProjectRequest;
import consolelog.project.dto.ProjectResponse;
import consolelog.project.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


import static consolelog.global.response.ResultCode.*;

@Tag(name = "Project", description = "Project API Document")
@RestController
@RequestMapping("/v1")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "프로젝트 조회", description = "프로젝트 조회")
    @GetMapping("/projects/{projectId}")
    public ResponseEntity<ResultResponse<ProjectResponse>> findProject(@Parameter(in = ParameterIn.PATH) @PathVariable Long projectId,
                                                                       @Parameter(in = ParameterIn.COOKIE) @CookieValue(value = "viewedProject", required = false, defaultValue = "") String projectLog) {
        ProjectResponse findProjectResponse = projectService.findProjectResponse(projectId, projectLog);
        String updatedLog = projectService.updateProjectLog(projectId, projectLog);
        ResponseCookie responseCookie = ResponseCookie.from("viewedProject", updatedLog).maxAge(86400L).build();
        ResultResponse<ProjectResponse> resultResponse = new ResultResponse<>(FIND_PROJECT_SUCCESS, findProjectResponse);

        return ResponseEntity.status(FIND_PROJECT_SUCCESS.getStatus())
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(resultResponse);
    }

    @Operation(summary = "프로젝트 생성", description = "프로젝트 생성")
    @PostMapping("/projects")
    public ResponseEntity<ResultResponse<URI>> addPost(@Valid @RequestBody ProjectRequest projectRequest,
                                                       @Login AuthInfo authInfo) {
        Long postId = projectService.addProject(projectRequest, authInfo);
        URI location = URI.create("/posts/" + postId);
        ResultResponse<URI> resultResponse = new ResultResponse<>(ADD_PROJECT_SUCCESS, location);

        return ResponseEntity.status(ADD_PROJECT_SUCCESS.getStatus()).body(resultResponse);
    }

    @Operation(summary = "프로젝트 수정", description = "프로젝트 수정")
    @PutMapping("/projects/{projectId}")
    public ResponseEntity<ResultResponse<ProjectResponse>> updatePost(@PathVariable Long projectId,
                                                                      @RequestBody ProjectRequest projectRequest,
                                                                      @Login AuthInfo authInfo) {
        projectService.updateProject(projectId, projectRequest, authInfo);
        ProjectResponse projectResponse = projectService.findProjectResponse(projectId, "N");
        ResultResponse<ProjectResponse> resultResponse = new ResultResponse<>(UPDATE_PROJECT_SUCCESS, projectResponse);

        return ResponseEntity.status(UPDATE_PROJECT_SUCCESS.getStatus()).body(resultResponse);
    }

    @Operation(summary = "프로젝트 삭제", description = "프로젝트 삭제")
    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<ResultResponse<String>> deletePost(@PathVariable Long projectId, @Login AuthInfo authInfo) {
        projectService.deleteProject(projectId, authInfo);
        ResultResponse<String> resultResponse = new ResultResponse<>(DELETE_SUCCESS);

        return ResponseEntity.status(DELETE_SUCCESS.getStatus()).body(resultResponse);
    }

    @Operation(summary = "프로젝트 리스트 조회", description = "프로젝트 리스트 조회")
    @GetMapping(path = "/projects/list")
    public ResponseEntity<ResultResponse<List<ProjectItemResponse>>> findProjectList(@Valid ProjectListRequest projectListRequest) {
        List<ProjectItemResponse> projectResponseList = projectService.findProjectListResponse(projectListRequest);

        ResultResponse<List<ProjectItemResponse>> listResultResponse
                = new ResultResponse<>(FIND_PROJECT_LIST_SUCCESS, projectResponseList);

        return ResponseEntity.status(FIND_PROJECT_LIST_SUCCESS.getStatus()).body(listResultResponse);
    }
}