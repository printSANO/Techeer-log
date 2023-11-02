package consolelog.post.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.post.dto.request.NewPostRequest;
import consolelog.post.dto.request.PostUpdateRequest;
import consolelog.post.dto.response.PagePostResponse;
import consolelog.post.dto.response.PostResponse;
import consolelog.post.service.PostService;
import consolelog.support.token.Login;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponse> findPost(@PathVariable Long id,
                                                 @CookieValue(value = "viewedPost", required = false, defaultValue = "") String postLog) {
        PostResponse findPostResponse = postService.findPost(id, postLog);
        String updatedLog = postService.updatePostLog(id, postLog);
        ResponseCookie responseCookie = ResponseCookie.from("viewedPost", updatedLog).maxAge(86400L).build();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, responseCookie.toString()).body(findPostResponse);
    }

    @PostMapping("/posts")
    public ResponseEntity<Void> addPost(@Valid @RequestBody NewPostRequest newPostRequest,
                                        @Login AuthInfo authInfo) {
        Long postId = postService.addPost(newPostRequest, authInfo);
        return ResponseEntity.created(URI.create("/posts/" + postId)).build();
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable Long id,
                                           @RequestBody PostUpdateRequest postUpdateRequest,
                                           @Login AuthInfo authInfo) {
        postService.updatePost(id, postUpdateRequest, authInfo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id, @Login AuthInfo authInfo) {
        postService.deletePost(id, authInfo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/post/{lastPostId}")
    public ResponseEntity<PagePostResponse> findPostList(@PathVariable Long lastPostId, Pageable pageable) {
        PagePostResponse postList = postService.findPostsByPage(lastPostId, pageable);
        return ResponseEntity.ok().body(postList);
    }


//    @GetMapping("{nickname}/{title}")
//    public ResponseEntity
//    public String getFindPostPath() {
//        @PathVariable String nickname;
//        @PathVariable String title;
//        Map<String, String> map = new HashMap<>();
//        map.put("nickname", nickname);
//        return new FindPostRequest(nickname, title);
}
