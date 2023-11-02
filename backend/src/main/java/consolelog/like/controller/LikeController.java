package consolelog.like.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.global.result.ResultResponse;
import consolelog.global.support.token.Login;
import consolelog.like.dto.LikeFlipResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import static consolelog.global.result.ResultCode.LIKE_SUCCESS;

@RestController
public class LikeController {
    private final Like likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PutMapping("/posts/{id}/like")
    public ResponseEntity<ResultResponse<LikeFlipResponse>> flipPostLike(@PathVariable("id") Long postId,
                                                                         @Login AuthInfo authInfo) {

        LikeFlipResponse likeFlipResponse = likeService.flipPostLike(postId, authInfo);
        ResultResponse<LikeFlipResponse> resultResponse = new ResultResponse<>(LIKE_SUCCESS, likeFlipResponse);
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    @PutMapping("/comments/{id}/like")
    public ResponseEntity<LikeFlipResponse> flipCommentLike(@PathVariable("id") Long commentId,
                                                            @Login AuthInfo authInfo) {
        LikeFlipResponse likeFlipResponse = likeService.flipCommentLike(commentId, authInfo);
        return ResponseEntity.ok(likeFlipResponse);
    }
}

