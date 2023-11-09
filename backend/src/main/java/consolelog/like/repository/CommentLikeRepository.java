package consolelog.like.repository;

import consolelog.comment.domain.Comment;
import consolelog.like.domain.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {

    void deleteAllByCommentId(Long id);

    boolean existsByMemberIdAndComment(Long memberId, Comment comment);

    Optional<CommentLike> findByMemberIdAndComment(Long memberId, Comment comment);
}
