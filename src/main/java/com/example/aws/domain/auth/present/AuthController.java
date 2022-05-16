package com.example.aws.domain.auth.present;

import com.example.aws.domain.auth.present.dto.response.TokenResponse;
import com.example.aws.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public TokenResponse reissue(@RequestHeader("Refresh-token") String refreshToken) {
        return authService.reissue(refreshToken);
    }
}
