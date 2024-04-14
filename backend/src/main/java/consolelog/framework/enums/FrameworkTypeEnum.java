package consolelog.framework.enums;

import lombok.Getter;

@Getter
public enum FrameworkTypeEnum {
    FRONTEND("FRONTEND"), BACKEND("BACKEND"), DEVOPS("DEVOPS");

    private final String name;

    FrameworkTypeEnum(String name) {
        this.name = name;
    }
}
