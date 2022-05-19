package com.example.aws.domain.user.service;

import com.example.aws.domain.user.domain.User;
import com.example.aws.domain.user.domain.repository.UserRepository;
import com.example.aws.domain.user.exception.PasswordMistmatch;
import com.example.aws.domain.user.exception.UserExistsException;
import com.example.aws.domain.user.exception.UserNotFoundException;
import com.example.aws.domain.user.present.dto.request.SigninRequest;
import com.example.aws.domain.user.present.dto.request.SignupRequest;
import com.example.aws.domain.user.present.dto.response.TokenResponse;
import com.example.aws.global.enums.Authority;
import com.example.aws.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public void signup(SignupRequest request) {
        if(userRepository.findByAccountId(request.getAccountId()).isPresent())
            throw UserExistsException.EXCEPTION;

        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .authority(Authority.USER)
                        .build()
        );
    }

    @Transactional(readOnly = true)
    public TokenResponse login(SigninRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMistmatch.EXCEPTION;
        }

        String access = jwtTokenProvider.generateAccessToken(request.getAccountId());
        String refresh = jwtTokenProvider.generateRefreshToken(request.getAccountId());

        return TokenResponse.builder()
                .accessToken(access)
                .refreshToken(refresh)
                .authority(user.getAuthority())
                .build();
    }
}
