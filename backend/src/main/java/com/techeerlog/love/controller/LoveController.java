package com.techeerlog.love.controller;


import com.techeerlog.auth.dto.AuthInfo;
import com.techeerlog.global.response.ResultResponse;
import com.techeerlog.global.support.token.Login;
import com.techeerlog.love.dto.LoveResponse;
import com.techeerlog.love.service.LoveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.techeerlog.global.response.ResultCode.*;


@Tag(name = "Love", description = "Love API Document")
@RestController
@RequestMapping("/v1")
public class LoveController {
    private final LoveService loveService;

    public LoveController(LoveService loveService) {
        this.loveService = loveService;
    }

    @Operation(summary = "좋아요", description = "좋아요")
    @PostMapping("/loves/{projectId}")
    public ResponseEntity<ResultResponse<LoveResponse>> addLove(@PathVariable("projectId") Long projectId,
                                                          @Login AuthInfo authInfo) {
        LoveResponse loveResponse = loveService.addLove(projectId, authInfo);
        ResultResponse<LoveResponse> resultResponse = new ResultResponse<>(LOVE_CREATED_SUCCESS, loveResponse);


        return ResponseEntity.status(LOVE_CREATED_SUCCESS.getStatus()).body(resultResponse);
    }

    @Operation(summary = "좋아요 취소", description = "좋아요 취소")
    @DeleteMapping("/loves/{projectId}")
    public ResponseEntity<ResultResponse<LoveResponse>> deleteLove(@PathVariable("projectId") Long projectId,
                                                             @Login AuthInfo authInfo) {
        LoveResponse loveResponse = loveService.deleteLove(projectId, authInfo);
        ResultResponse<LoveResponse> resultResponse = new ResultResponse<>(LOVE_DELETED_SUCCESS, loveResponse);

        return ResponseEntity.status(LOVE_DELETED_SUCCESS.getStatus()).body(resultResponse);
    }

}

