package consolelog.post.controller;

import consolelog.post.dto.request.NewPostRequest;
import consolelog.post.dto.response.PostResponse;
import consolelog.post.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponse> findPost(@PathVariable Long id) {
        PostResponse findPostResponse = postService.findPost(id);
        return ResponseEntity.ok().body(findPostResponse);
    }

    @PostMapping("/posts")
    public ResponseEntity<NewPostRequest> addPost(@Valid @RequestBody NewPostRequest newPostRequest) {
        Long postId = postService.addPost(newPostRequest);
        return ResponseEntity.created(URI.create("/posts/" + postId)).build();
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
