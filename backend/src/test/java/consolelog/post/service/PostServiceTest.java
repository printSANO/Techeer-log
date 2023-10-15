package consolelog.post.service;

import consolelog.post.dto.request.NewPostRequest;
import consolelog.post.dto.response.PostResponse;
import consolelog.post.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostServiceTest {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostService postService;

    @DisplayName(("게시글 조회"))
    @Test
    void findPost() {
    }

    @BeforeEach
    void setUp() {
    }

    @DisplayName(("게시글 추가"))
    @Test
    void addPost() {
        NewPostRequest newPostRequest = new NewPostRequest("제목", "내용");

        Long postId = postService.addPost(newPostRequest);
        PostResponse findPostResponse = postService.findPost(postId);

        assertAll(() -> assertThat(findPostResponse.getTitle()).isEqualTo(newPostRequest.getTitle()),
                () -> assertThat(findPostResponse.getContent()).isEqualTo(newPostRequest.getContent()));
    }
}