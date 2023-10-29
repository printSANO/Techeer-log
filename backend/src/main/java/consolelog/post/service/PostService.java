package consolelog.post.service;

import consolelog.post.domain.Post;
import consolelog.post.dto.request.NewPostRequest;
import consolelog.post.dto.response.PostResponse;
import consolelog.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository; // final로 선언하면 생성자에서만 값을 할당할 수 있음

    public PostService(PostRepository postRepository) { // 생성자 주입
        this.postRepository = postRepository;  // 생성자를 통해 PostRepository를 주입받음
    }


    public PostResponse findPost(Long postId) {// post_id 게시글 조회
        Post findPost = findPostById(postId);
        return PostResponse.of(findPost);
    }

    private Post findPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + postId));
    }

    public PostResponse findTitle(String title) {// post_title 게시글 조회
        Post findPost = findPostByTitle(title);
        return PostResponse.of(findPost);
    }

    private Post findPostByTitle(String title) {
        return postRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. title=" + title));
    }

    @Transactional
    public Long addPost(NewPostRequest newPostRequest) {
        Post post = createPost(newPostRequest);
        Optional<Post> savedPost = Optional.of(postRepository.save(post));
        return savedPost.orElseThrow(() -> new IllegalArgumentException("x")).getId();
    }

    private Post createPost(NewPostRequest newPostRequest) {
        return Post.builder()
                .title(newPostRequest.getTitle())
                .content(newPostRequest.getContent())
                .build();
    }
}



