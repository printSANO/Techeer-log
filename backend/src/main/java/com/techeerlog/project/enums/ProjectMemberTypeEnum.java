package com.techeerlog.project.enums;

import com.techeerlog.global.support.EnumModel;
import lombok.Getter;

@Getter
public enum ProjectMemberTypeEnum implements EnumModel {
    FRONTEND("FRONTEND"),
    BACKEND("BACKEND"),
    LEADER("LEADER"),
    DEVOPS("DEVOPS"),
    MENTOR("MENTOR")
    ;

    private final String name;

    ProjectMemberTypeEnum(String name) {
        this.name = name;
    }
}
