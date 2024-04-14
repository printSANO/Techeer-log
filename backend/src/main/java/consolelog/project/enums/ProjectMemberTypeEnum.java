package consolelog.project.enums;

import lombok.Getter;

@Getter
public enum ProjectMemberTypeEnum {
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
