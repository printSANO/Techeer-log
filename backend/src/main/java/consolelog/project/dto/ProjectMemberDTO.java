package consolelog.project.dto;

import consolelog.member.domain.Member;
import consolelog.project.domain.Project;
import consolelog.project.enums.ProjectMemberType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberDTO {
    private Long projectId;
    private Long memberId;

    @Enumerated(EnumType.STRING)
    private ProjectMemberType projectMemberType;
}
