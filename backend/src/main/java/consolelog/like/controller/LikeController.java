package consolelog.like.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.global.result.ResultResponse;
import consolelog.global.support.token.Login;
import consolelog.like.dto.LikeFlipResponse;
import consolelog.like.service.LikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static consolelog.global.result.ResultCode.LIKE_CREATED_SUCCESS;

@Tag(name = "Comment Like", description = "Comment Like API Document")
@RequestMapping("/")
@RestController
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @Operation(summary = "댓글 좋아요", description = "로그인 필요")
    @PutMapping("/comments/{id}/like")
    public ResponseEntity<ResultResponse<LikeFlipResponse>> flipCommentLike(@PathVariable("id") Long commentId,
                                                                            @Login AuthInfo authInfo) {
        likeService.flipCommentLike(commentId, authInfo);
        ResultResponse<LikeFlipResponse> resultResponse = new ResultResponse<>(LIKE_CREATED_SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }
}

