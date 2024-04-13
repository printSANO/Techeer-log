package consolelog.project.enums;

import lombok.Getter;

@Getter
public enum PlatformType {
    WEB("WEB"), APP("APP"), WEB_APP("WEB_APP");

    private final String name;

    PlatformType(String name) {
        this.name = name;
    }
}
