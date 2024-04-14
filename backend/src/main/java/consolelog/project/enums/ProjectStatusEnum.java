package consolelog.project.enums;

import lombok.Getter;

@Getter
public enum ProjectStatusEnum {
    RUNNING("RUNNING"), COMPLETED("COMPLETED"), PREPARING("PREPARING");

    private final String name;

    ProjectStatusEnum(String name) {
        this.name = name;
    }
}
