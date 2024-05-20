package com.techeerlog.framework.enums;

import com.techeerlog.global.support.EnumModel;
import lombok.Getter;

@Getter
public enum FrameworkTypeEnum implements EnumModel {
    FRONTEND("FRONTEND"), BACKEND("BACKEND"), DEVOPS("DEVOPS");

    private final String name;

    FrameworkTypeEnum(String name) {
        this.name = name;
    }
}
