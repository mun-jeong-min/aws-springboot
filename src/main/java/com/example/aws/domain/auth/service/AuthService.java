package com.example.aws.domain.auth.service;

import com.example.aws.domain.auth.domain.RefreshToken;
import com.example.aws.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.aws.domain.auth.present.dto.response.TokenResponse;
import com.example.aws.global.enums.Authority;
import com.example.aws.global.exception.InvalidJwtException;
import com.example.aws.global.exception.RefreshTokenNotFound;
import com.example.aws.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public TokenResponse reissue(String refreshToken) {
        if(!jwtTokenProvider.getTokenBody(refreshToken).get("typ").equals("refresh"))
            throw InvalidJwtException.EXCEPTION;

        RefreshToken updateRefreshToken = refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> RefreshTokenNotFound.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(updateRefreshToken.getAccountId());
        updateRefreshToken.updateToken(newRefreshToken);

        String newAccessToken = jwtTokenProvider.generateAccessToken(updateRefreshToken.getAccountId());

        return TokenResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(refreshToken)
                .authority(Authority.USER)
                .build();
    }
}
