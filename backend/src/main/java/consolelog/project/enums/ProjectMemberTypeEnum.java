package consolelog.project.enums;

import consolelog.global.support.EnumModel;
import lombok.Getter;

@Getter
public enum ProjectMemberTypeEnum implements EnumModel {
    FRONTEND("FRONTEND"),
    BACKEND("BACKEND"),
    DEVOPS("DEVOPS"),
    MENTOR("MENTOR")
    ;

    private final String name;

    ProjectMemberTypeEnum(String name) {
        this.name = name;
    }
}
