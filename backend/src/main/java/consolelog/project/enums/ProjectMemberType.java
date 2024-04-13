package consolelog.project.enums;

import lombok.Getter;

@Getter
public enum ProjectMemberType {
    FRONTEND("FRONTEND"),
    BACKEND("BACKEND"),
    DEVOPS("DEVOPS"),
    MENTOR("MENTOR")
    ;

    private final String name;

    ProjectMemberType(String name) {
        this.name = name;
    }
}
