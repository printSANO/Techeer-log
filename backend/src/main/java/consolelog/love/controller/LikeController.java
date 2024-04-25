package consolelog.love.controller;


import consolelog.auth.dto.AuthInfo;
import consolelog.global.response.ResultResponse;
import consolelog.global.support.token.Login;
import consolelog.love.service.LikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static consolelog.global.response.ResultCode.*;


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
    public ResponseEntity<ResultResponse<String>> addLove(@PathVariable Long projectId,
                                                          @Login AuthInfo authInfo) {
        likeService.addLove(projectId, authInfo);
        ResultResponse<String> resultResponse = new ResultResponse<>(LIKE_CREATED_SUCCESS);


        return ResponseEntity.status(LIKE_CREATED_SUCCESS.getStatus()).body(resultResponse);
    }

    @Operation(summary = "좋아요 취소", description = "좋아요 취소")
    @DeleteMapping("/loves/{projectId}")
    public ResponseEntity<ResultResponse<String>> deleteLove(@PathVariable Long projectId,
                                                             @Login AuthInfo authInfo) {
        likeService.deleteLove(projectId, authInfo);
        ResultResponse<String> resultResponse = new ResultResponse<>(LIKE_DELETED_SUCCESS);

        return ResponseEntity.status(LIKE_DELETED_SUCCESS.getStatus()).body(resultResponse);
    }

}

