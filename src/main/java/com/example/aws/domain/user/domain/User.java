package com.example.aws.domain.user.domain;

import com.example.aws.global.enums.Authority;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String accountId;

    @Column(length = 60, nullable = false)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String accountId, String password, Authority authority) {
        this.accountId = accountId;
        this.password = password;
        this.authority = authority;
    }
}
