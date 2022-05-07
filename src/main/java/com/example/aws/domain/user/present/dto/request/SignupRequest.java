package com.example.aws.domain.user.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SignupRequest {
    private String accountId;
    private String password;
}
