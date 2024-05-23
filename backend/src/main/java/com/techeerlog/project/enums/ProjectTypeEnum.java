package com.techeerlog.project.enums;

import com.techeerlog.global.support.EnumModel;
import lombok.Getter;

@Getter
public enum ProjectTypeEnum implements EnumModel {
    BOOTCAMP("BOOTCAMP"),
    TEAM_PROJECT("TEAM_PROJECT"),
    PERSONAL_PROJECT("PERSONAL_PROJECT"),
    ;

    private final String name;

    ProjectTypeEnum(String name) {
        this.name = name;
    }
}
