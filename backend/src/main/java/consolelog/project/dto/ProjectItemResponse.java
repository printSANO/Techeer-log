package consolelog.project.dto;

import consolelog.framework.dto.FrameworkResponse;
import consolelog.member.dto.MemberResponse;
import consolelog.project.enums.PlatformEnum;
import consolelog.project.enums.ProjectStatusEnum;
import consolelog.project.enums.ProjectTypeEnum;
import consolelog.project.enums.SemesterEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectItemResponse {
    private Long id;
    private String mainImageUrl;
    private String title;
    private String subtitle;
    private LocalDate startDate;
    private LocalDate endDate;
    private PlatformEnum platform;
    private ProjectTypeEnum projectType;
    private int year;
    private SemesterEnum semester;
    private ProjectStatusEnum projectStatus;
    private int viewCount = 0;
    private int loveCount = 0;
    private MemberResponse writer;
}
