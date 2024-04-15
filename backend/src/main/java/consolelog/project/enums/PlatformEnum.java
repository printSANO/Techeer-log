package consolelog.project.enums;

import lombok.Getter;

@Getter
public enum PlatformEnum {
    WEB("WEB"), APP("APP"), WEB_APP("WEB_APP");

    private final String name;

    PlatformEnum(String name) {
        this.name = name;
    }
}
