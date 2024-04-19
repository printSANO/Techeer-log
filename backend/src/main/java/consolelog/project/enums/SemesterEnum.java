package consolelog.project.enums;

import consolelog.global.support.EnumModel;
import lombok.Getter;

@Getter
public enum SemesterEnum implements EnumModel {
    FIRST("FIRST"), SECOND("SECOND");

    private final String name;

    SemesterEnum(String name) {
        this.name = name;
    }
}
