package com.techeerlog.global.mapper;

import com.techeerlog.member.domain.Member;
import com.techeerlog.member.dto.MemberResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-14T20:51:38+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberResponse memberToMemberResponse(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberResponse memberResponse = new MemberResponse();

        memberResponse.setId( member.getId() );
        memberResponse.setLoginId( member.getLoginId() );
        memberResponse.setNickname( member.getNickname() );
        memberResponse.setProfileImageUrl( member.getProfileImageUrl() );

        return memberResponse;
    }
}
