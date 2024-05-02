package consolelog.project.dto;

import consolelog.framework.dto.FrameworkRequest;
import consolelog.project.domain.NonRegisterProjectMember;
import consolelog.project.enums.PlatformEnum;
import consolelog.project.enums.ProjectStatusEnum;
import consolelog.project.enums.ProjectTypeEnum;
import consolelog.project.enums.SemesterEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Year;
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
    private PlatformEnum platform;
    private ProjectTypeEnum projectType;
    private int year;
    private SemesterEnum semester;
    private ProjectStatusEnum projectStatus;
    private String githubLink;
    private String blogLink;
    private String websiteLink;
    private String mainImageUrl;
    private List<ProjectMemberRequest> projectMemberRequestList;
    private List<NonRegisterProjectMemberRequest> nonRegisterProjectMemberRequestList;
    private List<FrameworkRequest> frameworkRequestList;
}
