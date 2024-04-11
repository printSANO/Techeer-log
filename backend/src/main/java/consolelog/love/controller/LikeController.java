package consolelog.love.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.global.response.ResultResponse;
import consolelog.global.support.token.Login;
import consolelog.love.dto.LikeFlipResponse;
import consolelog.love.service.LikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static consolelog.global.response.ResultCode.LIKE_CREATED_SUCCESS;


@Tag(name = "Like", description = "Like API Document")
@RestController
@RequestMapping("/v1")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @Operation(summary = "PostLike", description = "PostLike 누르기/취소하기, PostLike 개수")
    @PutMapping("/posts/{id}/like")
    public ResponseEntity<ResultResponse<LikeFlipResponse>> flipPostLike(@PathVariable("id") Long postId,
                                                                         @Login AuthInfo authInfo) {
        LikeFlipResponse likeFlipResponse = likeService.flipPostLike(postId, authInfo);
        ResultResponse<LikeFlipResponse> resultResponse = new ResultResponse<>(LIKE_CREATED_SUCCESS, likeFlipResponse);
        // 수정 필요
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }
}

