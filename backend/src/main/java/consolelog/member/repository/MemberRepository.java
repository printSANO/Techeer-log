package consolelog.member.repository;

import consolelog.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsMemberByUsernameValue(String username);

    Optional<Member> findById(Long id);

    @Query(value = "SELECT m.username.value FROM Member m where m.id = :id")
        //@Query("SELECT m.username.value FROM Member m WHERE m.id = :id")
    Optional<String> findUsernameValueById(@Param("id") Long id);
}
