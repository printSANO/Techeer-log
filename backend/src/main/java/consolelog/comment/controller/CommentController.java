package consolelog.comment.controller;

import consolelog.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;


    }

    @PostMapping("post/api/v1/comment")
    public ResponseEntity<Void> addComment(@PathVariable(name = "id") Long postId,
                                           @Valid @RequestBody NewCommentRequest newCommentRequest,
                                           @Login AuthInfo authInfo) {
        Long commentId = commentService.addComment(postId, newCommentRequest, authInfo);
        return ResponseEntity.created(URI.create("/comment" + commentId)).build();
    }

    @PostMapping

}
