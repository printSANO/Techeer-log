package consolelog.member.service;

import consolelog.member.domain.Email;
import consolelog.member.domain.Member;
import consolelog.member.domain.Password;
import consolelog.member.domain.Username;
import consolelog.member.dto.SignupRequest;
import consolelog.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void signUp(SignupRequest signupRequest) {
        Member member = Member.builder()
                .id(1L)
                .username(new Username(signupRequest.getUsername()))
                .password(new Password(signupRequest.getPassword()))
                .email(new Email(signupRequest.getEmail()))
                .build();
        memberRepository.save(member);
    }

}
