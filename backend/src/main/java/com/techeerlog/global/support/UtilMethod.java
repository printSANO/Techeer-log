package com.techeerlog.global.support;

import com.techeerlog.auth.dto.AuthInfo;
import com.techeerlog.member.domain.Member;
import com.techeerlog.member.exception.MemberNotFoundException;
import com.techeerlog.member.repository.MemberRepository;
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
