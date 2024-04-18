package consolelog.global.support;

import consolelog.auth.dto.AuthInfo;
import consolelog.member.domain.Member;
import consolelog.member.exception.MemberNotFoundException;
import consolelog.member.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class UtilMethod {
    private final MemberRepository memberRepository;

    public UtilMethod(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public Member findMemberByAuthInfo(AuthInfo authInfo) {
        return memberRepository.findById(authInfo.getId())
                .orElseThrow(MemberNotFoundException::new);
    }

    public void validateMemberId(Long memberId) {
        if (!memberRepository.existsById(memberId))
            throw new MemberNotFoundException();
    }
}
