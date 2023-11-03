package consolelog.comment.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.comment.dto.*;
import consolelog.comment.service.CommentService;
import consolelog.support.token.Login;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{id}/comments")
    public ResponseEntity<CommentResponse> addComment(@PathVariable(name = "id") Long postId,
                                                      @Valid @RequestBody NewCommentRequest newCommentRequest,
                                                      @Login AuthInfo authInfo) {
        Long commentId = commentService.addComment(postId, newCommentRequest, authInfo);
        CommentResponse commentResponse =
                new CommentResponse();
        return ResponseEntity.status(HttpStatus.OK).body(commentResponse);
    }

    //대댓글
    @PostMapping("/comments/{id}/reply")
    public ResponseEntity<Void> addReply(@PathVariable(name = "id") Long commentId,
                                         @Valid @RequestBody NewReplyRequest newReplyRequest,
                                         @Login AuthInfo authInfo) {
        Long replyId = commentService.addReply(commentId, newReplyRequest, authInfo);
        return ResponseEntity.created(URI.create("/comments/" + replyId)).build();
    }


    @GetMapping("/posts/{id}/comments")
    public ResponseEntity<CommentsResponse> findComments(@PathVariable(name = "id") Long postId,
                                                         @Login AuthInfo authInfo) {
        CommentsResponse commentsResponse = commentService.findComments(postId, authInfo);
        return ResponseEntity.status(HttpStatus.OK).body(commentsResponse);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<CommentResponse> updateComment(@PathVariable(name = "id") Long commentId,
                                                         @Valid @RequestBody UpdateCommentRequest updateCommentRequest,
                                                         @Login AuthInfo authInfo) {
        CommentResponse updatedComment = commentService.updateComment(commentId, updateCommentRequest, authInfo);
        return ResponseEntity.status(HttpStatus.OK).body(updatedComment);
    }


    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable(name = "id") Long commentId,
                                              @Login AuthInfo authInfo) {
        commentService.deleteComment(commentId, authInfo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
