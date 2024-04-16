package consolelog.project.enums;

import lombok.Getter;

@Getter
public enum SemesterEnum {
    FIRST("FIRST"), SECOND("SECOND");

    private final String name;

    SemesterEnum(String name) {
        this.name = name;
    }
}
