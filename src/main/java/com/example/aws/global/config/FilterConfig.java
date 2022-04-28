package com.example.aws.global.config;

import com.example.aws.global.error.ExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Override
    public void configure(HttpSecurity builder) {
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        builder.addFilterBefore(exceptionHandler, UsernamePasswordAuthenticationFilter.class);
    }
}
