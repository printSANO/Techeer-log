package consolelog.comment.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.comment.dto.*;
import consolelog.comment.service.CommentService;
import consolelog.global.result.ResultResponse;
import consolelog.global.support.token.Login;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static consolelog.global.result.ResultCode.*;

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
    @PostMapping("/posts/{id}/comments")
    public ResponseEntity<ResultResponse<CommentResponse>> addComment(@PathVariable(name = "id") Long postId,
                                                                      @Valid @RequestBody NewCommentRequest newCommentRequest,
                                                                      @Login AuthInfo authInfo) {

        // 수정 필요
        // 사용하지 않는 변수 삭제
        Long commentId = commentService.addComment(postId, newCommentRequest, authInfo);
        ResultResponse<CommentResponse> resultResponse = new ResultResponse<>(COMMENT_CREATED_SUCCESS);

        // 수정 필요
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    //대댓글
    @Operation(summary = "대댓글 생성", description = "대댓글 생성")
    @PostMapping("/comments/{id}/reply")
    public ResponseEntity<ResultResponse<ReplyResponse>> addReply(@PathVariable(name = "id") Long commentId,
                                                                  @Valid @RequestBody NewReplyRequest newReplyRequest,
                                                                  @Login AuthInfo authInfo) {

        // 수정 필요
        // 사용하지 않는 변수 삭제
        Long replyId = commentService.addReply(commentId, newReplyRequest, authInfo);
        ResultResponse<ReplyResponse> resultResponse = new ResultResponse<>(COMMENT_REPLY_CREATED_SUCCESS);

        // 수정 필요
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    @Operation(summary = "댓글 및 대댓글 조회")
    @GetMapping("/posts/{id}/comments")
    // 수정 필요
    // 반환값 오류
    public ResponseEntity<ResultResponse> findComments(@PathVariable(name = "id") Long postId,
                                                       @Login AuthInfo authInfo) {
        CommentsResponse commentsResponse = commentService.findComments(postId, authInfo);
        ResultResponse<CommentResponse> resultResponse = new ResultResponse<>(GET_COMMENT_SUCCESS, commentsResponse);
        // 수정 필요
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    @Operation(summary = "댓글 수정", description = "댓글 수정")
    @PutMapping("/comments/{id}")
    public ResponseEntity<ResultResponse<CommentResponse>> updateComment(@PathVariable(name = "id") Long commentId,
                                                                         @Valid @RequestBody UpdateCommentRequest updateCommentRequest,
                                                                         @Login AuthInfo authInfo) {
        commentService.updateComment(commentId, updateCommentRequest, authInfo);
        ResultResponse<CommentResponse> resultResponse = new ResultResponse<>(UPDATE_COMMENT_SUCCESS);
        // 수정 필요
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    @Operation(summary = "댓글 삭제", description = "댓글 삭제")

    @DeleteMapping("/comments/{id}")
    // 수정 필요
    public ResponseEntity<ResultResponse> deleteComment(@PathVariable(name = "id") Long commentId,
                                                        @Login AuthInfo authInfo) {
        commentService.deleteComment(commentId, authInfo);
        ResultResponse resultResponse = new ResultResponse<>(DELETE_COMMENT_SUCCESS);
        // 수정 필요
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }
}
