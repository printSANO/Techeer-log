package consolelog.member.enums;

import consolelog.global.support.EnumModel;
import lombok.Getter;

@Getter
public enum RoleType implements EnumModel {
    USER("USER"), ADMIN("ADMIN");

    private final String name;

    RoleType(String name) {
        this.name = name;
    }
}
