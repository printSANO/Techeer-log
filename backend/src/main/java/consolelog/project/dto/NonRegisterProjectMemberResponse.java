package consolelog.project.dto;

import consolelog.project.enums.ProjectMemberTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NonRegisterProjectMemberResponse {
    private String name;
    private ProjectMemberTypeEnum projectMemberTypeEnum;
}
