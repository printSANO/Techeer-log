package consolelog.project.enums;

import lombok.Getter;

@Getter
public enum SemesterType {
    FIRST("FIRST"), SECOND("SECOND");

    private final String name;

    SemesterType(String name) {
        this.name = name;
    }
}
