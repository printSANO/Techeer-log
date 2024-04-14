package consolelog.project.enums;

import lombok.Getter;

@Getter
public enum ProjectTypeEnum {
    BOOTCAMP("BOOTCAMP"), TEAM_PROJECT("TEAM_PROJECT");

    private final String name;

    ProjectTypeEnum(String name) {
        this.name = name;
    }
}
