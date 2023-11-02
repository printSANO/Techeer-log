package consolelog.post.controller;

import consolelog.auth.dto.AuthInfo;
import consolelog.global.result.ResultResponse;
import consolelog.global.support.token.Login;
import consolelog.post.dto.request.NewPostRequest;
import consolelog.post.dto.request.PostUpdateRequest;
import consolelog.post.dto.response.BoardResponse;
import consolelog.post.dto.response.PagePostResponse;
import consolelog.post.dto.response.PostResponse;
import consolelog.post.service.PostService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static consolelog.global.result.ResultCode.*;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

//    @GetMapping("/posts/{id}")
//    public ResponseEntity<PostResponse> findPost(@PathVariable Long id,
//                                                 @CookieValue(value = "viewedPost", required = false, defaultValue = "") String postLog) {
//        PostResponse findPostResponse = postService.findPost(id, postLog);
//        String updatedLog = postService.updatePostLog(id, postLog);
//        ResponseCookie responseCookie = ResponseCookie.from("viewedPost", updatedLog).maxAge(86400L).build();
//        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, responseCookie.toString()).body(findPostResponse);

    @GetMapping("/board/{id}")
    public ResponseEntity<ResultResponse<BoardResponse>> findBoard(@PathVariable Long id,
                                                                   @CookieValue(value = "viewedPost", required = false, defaultValue = "") String postLog) {
        BoardResponse findBoardResponse = postService.findBoard(id, postLog);
        String updatedLog = postService.updatePostLog(id, postLog);
        ResponseCookie responseCookie = ResponseCookie.from("viewedPost", updatedLog).maxAge(86400L).build();
        ResultResponse<BoardResponse> resultResponse = new ResultResponse<>(FINDBOARD_SUCCESS, findBoardResponse);
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(resultResponse);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<ResultResponse<PostResponse>> findPost(@PathVariable Long id,
                                                                 @Login AuthInfo authInfo,
                                                                 @CookieValue(value = "viewedPost", required = false, defaultValue = "") String postLog) {
        PostResponse findPostResponse = postService.findPost(id, authInfo, postLog);
        String updatedLog = postService.updatePostLog(id, postLog);
        ResponseCookie responseCookie = ResponseCookie.from("viewedPost", updatedLog).maxAge(86400L).build();
        ResultResponse<PostResponse> resultResponse = new ResultResponse<>(FINDPOST_SUCCESS, findPostResponse);
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(resultResponse);
    }

    @PostMapping("/posts")
    public ResponseEntity<ResultResponse<URI>> addPost(@Valid @RequestBody NewPostRequest newPostRequest,
                                                       @Login AuthInfo authInfo) {
        Long postId = postService.addPost(newPostRequest, authInfo);
        URI location = URI.create("/posts/" + postId);
        ResultResponse<URI> resultResponse = new ResultResponse<>(ADDPOST_SUCCESS, location);

        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<ResultResponse<String>> updatePost(@PathVariable Long id,
                                                             @RequestBody PostUpdateRequest postUpdateRequest,
                                                             @Login AuthInfo authInfo) {
        postService.updatePost(id, postUpdateRequest, authInfo);
        ResultResponse<String> resultResponse = new ResultResponse<>(UPDATEPOST_SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<ResultResponse<String>> deletePost(@PathVariable Long id, @Login AuthInfo authInfo) {
        postService.deletePost(id, authInfo);
        ResultResponse<String> resultResponse = new ResultResponse<>(DELETE_SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    @GetMapping(path = "/post/{lastPostId}")
    public ResponseEntity<ResultResponse<PagePostResponse>> findPostList(@PathVariable Long lastPostId, Pageable pageable) {
        PagePostResponse postList = postService.findPostsByPage(lastPostId, pageable);
        ResultResponse<PagePostResponse> resultResponse = new ResultResponse<>(FINDPOSTLIST_SUCCESS, postList);
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
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
