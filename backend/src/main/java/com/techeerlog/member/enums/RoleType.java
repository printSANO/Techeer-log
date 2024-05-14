package com.techeerlog.member.enums;

import com.techeerlog.global.support.EnumModel;
import lombok.Getter;

@Getter
public enum RoleType implements EnumModel {
    USER("USER"), ADMIN("ADMIN");

    private final String name;

    RoleType(String name) {
        this.name = name;
    }
}
