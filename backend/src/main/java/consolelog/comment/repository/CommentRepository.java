package consolelog.comment.repository;

import consolelog.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
//    @Query(value = "SELECT c.nickname FROM Comment c WHERE c.post = :post AND c.member = :member")
//    List<String> findNickNamesByPostAndMember(Post post, Member member);
//
//    @Query(value = "SELECT c.nickname FROM Comment c WHERE c.post.id = :postId")
//    List<String> findNicknamesByPostId(@Param("postId") Long postId);

//    @Query(value = "SELECT c FROM Comment c WHERE c.post.id = :postId and c.parent.id is null")
//    List<Comment> findCommentsByPostId(@Param("postId") Long postId);

    List<Comment> findCommentsByPostId(Long postId);

    List<Comment> findRepliesByParent(Comment parent);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE comment SET like_count = like_count + 1 WHERE comment_id = :commentId", nativeQuery = true)
    void increaseLikeCount(Long commentId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE comment SET like_count = like_count - 1 WHERE comment_id = :commentId", nativeQuery = true)
    void decreaseLikeCount(Long commentId);
}
