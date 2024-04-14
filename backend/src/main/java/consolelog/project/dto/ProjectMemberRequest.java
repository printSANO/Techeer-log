package consolelog.project.dto;

import consolelog.project.enums.ProjectMemberTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberRequest {
    private Long memberId;

    @Enumerated(EnumType.STRING)
    private ProjectMemberTypeEnum projectMemberTypeEnum;
}
