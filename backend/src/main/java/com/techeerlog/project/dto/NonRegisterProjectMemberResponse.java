package com.techeerlog.project.dto;

import com.techeerlog.project.enums.ProjectMemberTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NonRegisterProjectMemberResponse {
    private String name;
    private ProjectMemberTypeEnum projectMemberTypeEnum;
}
