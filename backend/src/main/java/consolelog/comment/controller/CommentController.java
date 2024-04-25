package consolelog.comment.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.comment.dto.*;
import consolelog.comment.service.CommentService;
import consolelog.global.response.ResultResponse;
import consolelog.global.support.token.Login;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static consolelog.global.response.ResultCode.*;

// 수정 필요
// Reply 와 Comment 는 동일한 객체이다. (ERD 에서 통일된 객체로 다루고 있기 때문이다)
// 그런데, 불 필요하게 CommentResponse 와 ReplyResponse, CommentRequest 와 ReplyRequest 와 UpdateCommentRequest
// 가 분리되어 있다. 전부 하나로 합쳐서 동작하도록 수정해야한다
// 메세지 내용을 바꾸고 싶다면, NotBlank 를 사용하지 말고 다른 방법을 찾아보거나
// 그냥, "메세지를 작성해주세요." 로 통일해도 상관없다

@Tag(name = "Comment", description = "Comment API Document")
@RestController
@RequestMapping("/v1")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(summary = "댓글 생성", description = "댓글 생성")
    @PostMapping("/comments")
    public ResponseEntity<ResultResponse<String>> addComment(@Valid @RequestBody CommentRequest commentRequest,
                                                                      @Login AuthInfo authInfo) {


        CommentResponse commentResponse = commentService.addComment(commentRequest, authInfo);
        String commentLocation = "/comments/" + commentResponse.getCommentId();
        ResultResponse<String> resultResponse = new ResultResponse<>(COMMENT_CREATED_SUCCESS, commentLocation);


        return ResponseEntity.status(COMMENT_CREATED_SUCCESS.getStatus()).body(resultResponse);
    }

    @Operation(summary = "댓글 조회")
    @GetMapping("/comments/{commentId}")
    public ResponseEntity<ResultResponse<CommentsResponse>> findComments(@PathVariable Long commentId,
                                                       @Login AuthInfo authInfo) {
        CommentsResponse commentsResponse = commentService.findComments(commentId, authInfo);
        ResultResponse<CommentsResponse> resultResponse = new ResultResponse<>(GET_COMMENT_SUCCESS, commentsResponse);

        return ResponseEntity.status(GET_COMMENT_SUCCESS.getStatus()).body(resultResponse);
    }

    @Operation(summary = "댓글 수정", description = "댓글 수정")
    @PutMapping("/comments/{commentId}")
    public ResponseEntity<ResultResponse<CommentResponse>> updateComment(@PathVariable Long commentId,
                                                                         @Valid @RequestBody CommentRequest commentRequest,
                                                                         @Login AuthInfo authInfo) {
        CommentResponse updatedCommentResponse = commentService.updateComment(commentId, commentRequest, authInfo);
        ResultResponse<CommentResponse> resultResponse = new ResultResponse<>(UPDATE_COMMENT_SUCCESS, updatedCommentResponse);

        return ResponseEntity.status(UPDATE_COMMENT_SUCCESS.getStatus()).body(resultResponse);
    }

    @Operation(summary = "댓글 삭제", description = "댓글 삭제")
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ResultResponse<String>> deleteComment(@PathVariable Long commentId,
                                                                @Login AuthInfo authInfo) {
        commentService.deleteComment(commentId, authInfo);
        ResultResponse<String> resultResponse = new ResultResponse<>(DELETE_COMMENT_SUCCESS);

        return ResponseEntity.status(DELETE_COMMENT_SUCCESS.getStatus()).body(resultResponse);
    }
}
