package com.example.aws.domain.auth.present.dto.response;

import com.example.aws.global.enums.Authority;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class TokenResponse {

    private final String accessToken;
    private final String refreshToken;
    private final Authority authority;
}
