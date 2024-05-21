package com.techeerlog.love.controller;


import com.techeerlog.auth.dto.AuthInfo;
import com.techeerlog.global.response.SimpleResultResponse;
import com.techeerlog.global.support.token.Login;
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
    public ResponseEntity<SimpleResultResponse> addLove(@PathVariable("projectId") Long projectId,
                                                                @Login AuthInfo authInfo) {
        loveService.addLove(projectId, authInfo);
        SimpleResultResponse resultResponse = new SimpleResultResponse(LOVE_CREATED_SUCCESS);

        return ResponseEntity.status(LOVE_CREATED_SUCCESS.getStatus()).body(resultResponse);
    }

    @Operation(summary = "좋아요 취소", description = "좋아요 취소")
    @DeleteMapping("/loves/{projectId}")
    public ResponseEntity<SimpleResultResponse> deleteLove(@PathVariable("projectId") Long projectId,
                                                             @Login AuthInfo authInfo) {
        loveService.deleteLove(projectId, authInfo);
        SimpleResultResponse resultResponse = new SimpleResultResponse(LOVE_DELETED_SUCCESS);

        return ResponseEntity.status(LOVE_DELETED_SUCCESS.getStatus()).body(resultResponse);
    }

}

