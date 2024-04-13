package consolelog.project.dto;

import consolelog.project.domain.Project;
import consolelog.project.enums.PlatformType;
import consolelog.project.enums.ProjectStatusType;
import consolelog.project.enums.ProjectTypeType;
import consolelog.project.enums.SemesterType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private PlatformType platform;
    private ProjectTypeType projectType;
    private SemesterType semester;
    private ProjectStatusType projectStatus;
    private String githubLink;
    private String blogLink;
    private String websiteLink;
    private int viewCount = 0;
    private int likeCount = 0;
}
