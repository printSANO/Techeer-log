package consolelog.member.repository;

import consolelog.member.domain.Member;
import consolelog.member.domain.Nickname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);

    boolean existsMemberByLoginIDValue(String username);

    boolean existsMemberByNickname(Nickname nickname);

    boolean existsMemberByNicknameValue(String nickname);
}
