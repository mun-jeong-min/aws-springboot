package com.example.aws.global.config;

import com.example.aws.global.security.jwt.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = JwtProperties.class)
@Configuration
public class PropertiesConfig {
}
