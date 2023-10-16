package consolelog.comment.controller;

import consolelog.comment.dto.CommentResponse;
import consolelog.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //댓글 추가
    @PostMapping("/posts/{id}/comment")
    public ResponseEntity<Void> addComment(@PathVariable(name = "id") Long postId,
                                           @Valid @RequestBody NewCommentRequest newCommentRequest,
                                           @Login AuthInfo authInfo) {
        Long commentId = commentService.addComment(postId, newCommentRequest, authInfo);
        return ResponseEntity.created(URI.create("/comment/" + commentId)).build();
    }

    //대댓글
    @PostMapping("/comment/{id}/reply")
    public ResponseEntity<Void> addReply(@PathVariable(name = "id") Long CommentId,
                                         @Valid @RequestBody NewReplyRequest newReplyRequest,
                                         @Login AuthInfo authInfo) {
        Long replyId = commentService.addReply(commentId, newReplyRequest, authInfo);
        return ResponseEntity.created(URI.create("/comments/" + replyId).build());
    }


    @GetMapping("/posts/{id}/comment")
    public ResponseEntity<CommentResponse> findComments(@PathVariable(name = "id") Long postId,
                                                        @Login AuthInfo authInfo) {
        commentService.deleteComment(commentId, authInfo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable(name = "id") Long commentId,
                                              @Login AuthInfo authInfo) {
        commentService.deleteComment(commentId, authInfo);
        return ResponseEntity.noContent().build();
    }

}