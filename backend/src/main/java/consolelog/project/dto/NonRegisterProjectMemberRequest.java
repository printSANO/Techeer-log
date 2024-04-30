package consolelog.project.dto;

import consolelog.project.enums.ProjectMemberTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NonRegisterProjectMemberRequest {
    private String name;
    private ProjectMemberTypeEnum projectMemberTypeEnum;
}
