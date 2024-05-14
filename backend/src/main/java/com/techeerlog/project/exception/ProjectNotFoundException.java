package com.techeerlog.project.exception;


import com.techeerlog.global.exception.BusinessException;
import com.techeerlog.global.response.ErrorCode;

public class ProjectNotFoundException extends BusinessException {

    public ProjectNotFoundException() {
        super(ErrorCode.PROJECT_NOT_FOUND_ERROR);
    }
}
