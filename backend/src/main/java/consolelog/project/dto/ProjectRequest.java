package consolelog.project.dto;

import consolelog.project.domain.ProjectMember;
import consolelog.project.enums.PlatformType;
import consolelog.project.enums.ProjectStatusType;
import consolelog.project.enums.ProjectTypeType;
import consolelog.project.enums.SemesterType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequest {
    private String title;
    private String subtitle;
    private String content;
    private LocalDate startDate;
    private LocalDate endDate;
    private PlatformType platform;
    private ProjectTypeType projectType;
    private SemesterType semester;
    private ProjectStatusType projectStatus;
    private String githubLink;
    private String blogLink;
    private String websiteLink;
    private String mainImageUrl;
    private List<ProjectMemberDTO> projectMemberDTOList;
}
