package consolelog.member.dto;

import consolelog.member.domain.Member;
import org.mapstruct.Mapper;

@Mapper
public interface MemberMapper {
    MemberResponse memberToMemberResponse(Member member);
    Member memberResponseToMember(MemberResponse memberResponse);
}
