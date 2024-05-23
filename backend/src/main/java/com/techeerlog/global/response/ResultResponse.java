package com.techeerlog.global.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class ResultResponse<T> {
    private final String code;
    private final String message;
    private T data;


    @JsonCreator
    public ResultResponse(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    @JsonCreator
    public ResultResponse(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
}