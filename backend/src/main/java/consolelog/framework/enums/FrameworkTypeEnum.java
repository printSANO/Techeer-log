package consolelog.framework.enums;

import consolelog.global.support.EnumModel;
import lombok.Getter;

@Getter
public enum FrameworkTypeEnum implements EnumModel {
    FRONTEND("FRONTEND"), BACKEND("BACKEND"), DEVOPS("DEVOPS");

    private final String name;

    FrameworkTypeEnum(String name) {
        this.name = name;
    }
}
