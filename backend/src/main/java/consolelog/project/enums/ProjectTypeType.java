package consolelog.project.enums;

import lombok.Getter;

@Getter
public enum ProjectTypeType {
    BOOTCAMP("BOOTCAMP"), TEAM_PROJECT("TEAM_PROJECT");

    private final String name;

    ProjectTypeType(String name) {
        this.name = name;
    }
}
