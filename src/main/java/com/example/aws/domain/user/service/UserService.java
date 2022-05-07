package com.example.aws.domain.user.service;

import com.example.aws.domain.user.domain.User;
import com.example.aws.domain.user.domain.repository.UserRepository;
import com.example.aws.domain.user.exception.UserExistsException;
import com.example.aws.domain.user.present.dto.request.SignupRequest;
import com.example.aws.global.enums.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupRequest request) {
        if(userRepository.findByAccountId(request.getAccountId()).isPresent()) {
            throw UserExistsException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .authority(Authority.USER)
                        .build()
        );
    }
}
