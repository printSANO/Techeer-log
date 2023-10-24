package consolelog.comment.repository;

import consolelog.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT c.nickname FROM Comment c WHERE c.post = :post AND c.member = :member")
    List<String> findNickNamesByPostAndMember(Post post, Member member);

    
}
