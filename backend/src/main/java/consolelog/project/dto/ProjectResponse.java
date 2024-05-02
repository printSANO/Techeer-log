package consolelog.project.dto;

import consolelog.framework.dto.FrameworkResponse;
import consolelog.member.dto.MemberResponse;
import consolelog.project.enums.PlatformEnum;
import consolelog.project.enums.ProjectStatusEnum;
import consolelog.project.enums.ProjectTypeEnum;
import consolelog.project.enums.SemesterEnum;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {
    private Long id;
    private String mainImageUrl;
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
    private int viewCount = 0;
    private int loveCount = 0;
    private MemberResponse writer;
    private List<ProjectMemberResponse> projectMemberResponseList;
    private List<NonRegisterProjectMemberResponse> nonRegisterProjectMemberResponseList;
    private List<FrameworkResponse> frameworkResponseList;
}
