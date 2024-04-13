package consolelog.project.enums;

import lombok.Getter;

@Getter
public enum ProjectStatusType {
    RUNNING("RUNNING"), COMPLETED("COMPLETED"), PREPARING("PREPARING");

    private final String name;

    ProjectStatusType(String name) {
        this.name = name;
    }
}
