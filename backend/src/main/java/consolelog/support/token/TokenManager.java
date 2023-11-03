package consolelog.support.token;

import consolelog.auth.dto.AuthInfo;

public interface TokenManager {
    String createAccessToken(AuthInfo authInfo);

    String createRefreshToken();

    String getPayload(String token);

    // token에 저장된 정보에서 AuthInfo를 추출하는 함수
    AuthInfo getParsedClaims(String token);

    boolean isValid(String token);

    String createNewTokenWithNewNickname(String newNickname, AuthInfo authInfo);

}
