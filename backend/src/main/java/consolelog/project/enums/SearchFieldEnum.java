package consolelog.project.enums;

import lombok.Getter;

@Getter
public enum SearchFieldEnum {
    TITLE("TITLE"),
    WRITER("WRITER"),
    CONTENT("CONTENT"),
    ALL("ALL"),
    ;

    private final String name;

    SearchFieldEnum(String name) {
        this.name = name;
    }
}
