package consolelog.like.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.like.dto.LikeFlipResponse;
import consolelog.like.service.LikeService;
import consolelog.support.token.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PutMapping("/posts/{id}/like")
    public ResponseEntity<LikeFlipResponse> flipPostLike(@PathVariable("id") Long postId,
                                                         @Login AuthInfo authInfo) {

        LikeFlipResponse likeFlipResponse = likeService.flipPostLike(postId, authInfo);
        return ResponseEntity.ok(likeFlipResponse);
    }

}
