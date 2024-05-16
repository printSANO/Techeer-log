package com.techeerlog.global.support.token;


import com.techeerlog.auth.dto.AuthInfo;

public interface TokenManager {
    String createAccessToken(AuthInfo authInfo);

    String createAnonymousAccessToken();

    String createRefreshToken();

    String getPayload(String token);

    // token에 저장된 정보에서 AuthInfo를 추출하는 함수
    AuthInfo getParsedClaims(String token);

    boolean isValid(String token);

    String createNewTokenWithNewNickname(String newNickname, AuthInfo authInfo);

    boolean isAnonymousToken(String token);
}
