package com.techeerlog.project.dto;

import com.techeerlog.project.enums.ProjectMemberTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NonRegisterProjectMemberRequest {
    private String name;
    private ProjectMemberTypeEnum projectMemberTypeEnum;
}
