//package consolelog.post.repository;
//
//
//import consolelog.post.domain.Post;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Objects;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@DataJpaTest
//@AutoConfigureTestDatabase
//class PostRepositoryTest {
//    @Autowired
//    private PostRepository postRepository;
//
//
//    @Test
//    void findById() {
//
//        Post post = Post.builder()
//                .title("title")
//                .content("content")
//                .build();
//
//        Optional<Post> savePost = Optional.of(postRepository.save(post));
//        Long postId = savePost.get().getId();
//
//        Optional<Post> findPost = postRepository.findById(postId);
//
//        assertAll(
//                () -> assertThat(findPost).isPresent(),
//                () -> Objects.requireNonNull(findPost).ifPresent(selectPost -> {
//                    assertThat(selectPost.getId()).isEqualTo(postId);
//                    assertEquals("title", selectPost.getTitle());
//                    assertEquals("content", selectPost.getContent());
//                })
//        );
//
//    }
//
//}