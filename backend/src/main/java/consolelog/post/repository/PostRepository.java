package consolelog.post.repository;

import consolelog.post.domain.Post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    Optional<Post> findById(Long id);

    Optional<Post> findByTitle(String title);

    @Query("select p from Post p where p.id < :lastPostId order by p.id DESC")
    Slice<Post> findByIdIsLessThanOrderByIdDesc(@Param("lastPostId") Long lastPostId, Pageable pageable);

    @Query(value = "select case  when count(p) > 0 then true else false end from Post p where p.id > :lastPostId")
    Boolean hasNextPage(@Param("lastPostId") Long lastPostId);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE post SET like_count = like_count + 1 WHERE post_id = :postId", nativeQuery = true)
    void increaseLikeCount(@Param("postId") Long postId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Post set like_count = like_count - 1 where post_id = :postId", nativeQuery = true)
    void decreaseLikeCount(@Param("postId") Long postId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE post SET view_count = view+count + 1 WHERE post_id = :postId", nativeQuery = true)
    void updateViewCount(@Param("postId") Long postId);
}
