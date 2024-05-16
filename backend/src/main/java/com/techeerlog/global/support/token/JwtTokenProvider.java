package com.techeerlog.global.support.token;

import com.techeerlog.auth.dto.AuthInfo;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider implements TokenManager {

    private final Key signingKey;

    private final long validityInMilliseconds;
    private final long refreshTokenValidityMilliseconds;

    public JwtTokenProvider(@Value("${security.jwt.token.secret}") String secretKey,
                            @Value("${security.jwt.token.expire-length.access}") long validityInMilliseconds,
                            @Value("${security.jwt.token.expire-length.refresh}") long refreshTokenValidityMilliseconds) {

        // 문자열에서 byte로 변환해, Keys의 hmacShaKeyFor 함수를 이용해 Key 자료형의 형태로 byte를 변환
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        this.signingKey = Keys.hmacShaKeyFor(keyBytes);
        this.validityInMilliseconds = validityInMilliseconds;
        this.refreshTokenValidityMilliseconds = refreshTokenValidityMilliseconds;
    }

    @Override
    public String createAccessToken(AuthInfo authInfo) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .claim("id", authInfo.getId())
                .claim("type", authInfo.getType())
                .claim("nickname", authInfo.getNickname())
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(signingKey)
                .compact();
    }

    @Override
    public String createAnonymousAccessToken() {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .claim("id", "-1")
                .claim("type", "anonymous")
                .claim("nickname", "anonymous")
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(signingKey)
                .compact();
    }

    @Override
    public String createRefreshToken() {
        Date now = new Date();
        Date validity = new Date(now.getTime() + refreshTokenValidityMilliseconds);

        return Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(signingKey)
                .compact();
    }

    @Override
    public String getPayload(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    @Override
    public AuthInfo getParsedClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            Long id = e.getClaims().get("id", Long.class);
            String type = e.getClaims().get("type", String.class);
            String nickname = e.getClaims().get("nickname", String.class);
            return new AuthInfo(id, type, nickname);
        }
        Long id = claims.get("id", Long.class);
        String type = claims.get("type", String.class);
        String nickname = claims.get("nickname", String.class);
        return new AuthInfo(id, type, nickname);
    }

    @Override
    public boolean isValid(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token);

            Date expirationDate = claimsJws.getBody().getExpiration();
            // 기한이 현재날짜가 expDate 이전이면 True 아니면 False 반환
            return new Date().before(expirationDate);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public String createNewTokenWithNewNickname(String newNickname, AuthInfo authInfo) {
        AuthInfo newAuthInfo = new AuthInfo(authInfo.getId(), authInfo.getType(), newNickname);
        return this.createAccessToken(newAuthInfo);
    }
}
