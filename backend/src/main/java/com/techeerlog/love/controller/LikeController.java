package com.techeerlog.love.controller;


import com.techeerlog.auth.dto.AuthInfo;
import com.techeerlog.global.response.ResultResponse;
import com.techeerlog.global.support.token.Login;
import com.techeerlog.love.service.LikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.techeerlog.global.response.ResultCode.LIKE_CREATED_SUCCESS;
import static com.techeerlog.global.response.ResultCode.LIKE_DELETED_SUCCESS;


@Tag(name = "Like", description = "Like API Document")
@RestController
@RequestMapping("/v1")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @Operation(summary = "좋아요", description = "좋아요")
    @PostMapping("/loves/{projectId}")
    public ResponseEntity<ResultResponse<String>> addLove(@PathVariable("projectId") Long projectId,
                                                          @Login AuthInfo authInfo) {
        likeService.addLove(projectId, authInfo);
        ResultResponse<String> resultResponse = new ResultResponse<>(LIKE_CREATED_SUCCESS);


        return ResponseEntity.status(LIKE_CREATED_SUCCESS.getStatus()).body(resultResponse);
    }

    @Operation(summary = "좋아요 취소", description = "좋아요 취소")
    @DeleteMapping("/loves/{projectId}")
    public ResponseEntity<ResultResponse<String>> deleteLove(@PathVariable("projectId") Long projectId,
                                                             @Login AuthInfo authInfo) {
        likeService.deleteLove(projectId, authInfo);
        ResultResponse<String> resultResponse = new ResultResponse<>(LIKE_DELETED_SUCCESS);

        return ResponseEntity.status(LIKE_DELETED_SUCCESS.getStatus()).body(resultResponse);
    }

}

