package consolelog.comment.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.comment.domain.Comment;
import consolelog.comment.dto.*;
import consolelog.comment.service.CommentService;
import consolelog.result.ResultResponse;
import consolelog.support.token.Login;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static consolelog.result.ResultCode.*;

@Tag(name = "Comment", description = "Comment API Document")
@RequestMapping("/")
@RestController
//@RequiredArgsConstructor
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
        commentService.addComment(postId, newCommentRequest, authInfo);
        ResultResponse<CommentResponse> resultResponse = new ResultResponse<>(COMMENT_CREATED_SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    //대댓글
    @Operation(summary = "대댓글 생성", description = "대댓글 생성")
    @PostMapping("/comments/{id}/reply")
    public ResponseEntity<ResultResponse<CommentResponse>> addReply(@PathVariable(name = "id") Long commentId,
                                                                    @Valid @RequestBody NewReplyRequest newReplyRequest,
                                                                    @Login AuthInfo authInfo) {
        commentService.addReply(commentId, newReplyRequest, authInfo);
        ResultResponse<CommentResponse> resultResponse = new ResultResponse<>(COMMENT_REPLY_CREATED_SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    @Operation(summary = "댓글 및 대댓글 조회")
    @GetMapping("/posts/{id}/comments")
    public ResponseEntity<ResultResponse> findComments(@PathVariable(name = "id") Long postId,
                                                       @Login AuthInfo authInfo) {
        commentService.findComments(postId, authInfo);
        ResultResponse<Comment> resultResponse = new ResultResponse<>(GET_COMMENT_SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    @Operation(summary = "댓글 수정", description = "댓글 수정")
    @PutMapping("/comments/{id}")
    public ResponseEntity<ResultResponse<CommentResponse>> updateComment(@PathVariable(name = "id") Long commentId,
                                                                         @Valid @RequestBody UpdateCommentRequest updateCommentRequest,
                                                                         @Login AuthInfo authInfo) {
        commentService.updateComment(commentId, updateCommentRequest, authInfo);
        ResultResponse<CommentResponse> resultResponse = new ResultResponse<>(UPDATE_COMMENT_SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    @Operation(summary = "댓글 삭제", description = "댓글 삭제")

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<ResultResponse> deleteComment(@PathVariable(name = "id") Long commentId,
                                                        @Login AuthInfo authInfo) {
        commentService.deleteComment(commentId, authInfo);
        ResultResponse resultResponse = new ResultResponse<>(DELETE_COMMENT_SUCCESS);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(resultResponse);
    }
}
