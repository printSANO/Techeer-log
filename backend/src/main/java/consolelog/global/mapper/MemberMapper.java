package consolelog.global.mapper;

import consolelog.member.domain.Member;
import consolelog.member.dto.MemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    MemberResponse memberToMemberResponse(Member member);
}
