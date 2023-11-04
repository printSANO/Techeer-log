package consolelog.like.repository;

import consolelog.like.domain.PostLike;
import consolelog.member.domain.Member;
import consolelog.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    void deleteAllByPost(Post post);


    boolean existsByPostAndMemberId(Post post, Long memberId);


    @Query("select p from PostLike p where p.post = ?1 and p.member.id = ?2")
    Optional<PostLike> findByPostAndMemberId(Post post, Long memberId);

    Optional<PostLike> findByPostAndMember(Post post, Member member);


}
