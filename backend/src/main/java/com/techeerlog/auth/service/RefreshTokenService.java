package com.techeerlog.auth.service;

import com.techeerlog.auth.domain.RefreshToken;
import com.techeerlog.auth.repository.RefreshTokenRepository;
import com.techeerlog.global.exception.InvalidRefreshTokenException;
import com.techeerlog.global.support.token.TokenManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final TokenManager tokenManager;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository, TokenManager tokenManager) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.tokenManager = tokenManager;
    }

    @Transactional
    public void saveToken(String token, Long memberId) {
        Optional<RefreshToken> optionalRefreshToken = refreshTokenRepository.findRefreshTokenByMemberId(memberId);
        if (optionalRefreshToken.isPresent()) {
            RefreshToken existingToken = optionalRefreshToken.get();
            existingToken.setToken(token);
            refreshTokenRepository.save(existingToken);
        } else {
            RefreshToken newRefreshToken = new RefreshToken(memberId, token);
            refreshTokenRepository.save(newRefreshToken);
        }
    }

    @Transactional
    public void matches(String refreshToken, Long memberId) {
        RefreshToken savedToken = refreshTokenRepository.findRefreshTokenByMemberId(memberId)
                .orElseThrow(InvalidRefreshTokenException::new);

        // db에 저장된 refreshToken 이 유효기간이 지났지 않은지 체크
        if (!tokenManager.isValid(savedToken.getToken())) {
            refreshTokenRepository.delete(savedToken);
            throw new InvalidRefreshTokenException();
        }
        savedToken.validateSameToken(refreshToken);
    }

    @Transactional
    public void deleteToken(Long memberId) {
        refreshTokenRepository.deleteAllByMemberId(memberId);
    }
}
