package com.example.aws.domain.user.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SigninRequest {
    private String accountId;
    private String password;
}
