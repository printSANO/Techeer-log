package consolelog.member.repository;

import consolelog.member.domain.Member;
import consolelog.member.domain.Nickname;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);

    boolean existsMemberByLoginIdValue(String loginId);

    boolean existsMemberByNickname(Nickname nickname);

    boolean existsMemberByNicknameValue(String nickname);

    Optional<Member> findByLoginIdValueAndPasswordValue(String loginId, String password);
}
