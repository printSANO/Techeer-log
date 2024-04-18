package consolelog.project.enums;

import lombok.Getter;

@Getter
public enum SearchFieldEnum {
    TITLE("TITLE"),
    WRITER("WRITER"),
    TEAM_MEMBER("TEAM_MEMBER"),
    CONTENT("CONTENT"),
    ALL("ALL"),
    ;

    private final String name;

    SearchFieldEnum(String name) {
        this.name = name;
    }
}
