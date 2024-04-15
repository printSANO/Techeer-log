package consolelog.project.dto;

import consolelog.member.dto.MemberResponse;
import consolelog.project.enums.ProjectMemberTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberResponse {
    private MemberResponse memberResponse;
    private ProjectMemberTypeEnum projectMemberTypeEnum;
}
