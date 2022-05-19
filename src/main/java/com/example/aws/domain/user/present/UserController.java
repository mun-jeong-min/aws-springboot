package com.example.aws.domain.user.present;

import com.example.aws.domain.user.present.dto.request.SigninRequest;
import com.example.aws.domain.user.present.dto.request.SignupRequest;
import com.example.aws.domain.user.present.dto.response.TokenResponse;
import com.example.aws.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid SignupRequest request) {
        userService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid SigninRequest request) {
        return userService.login(request);
    }
}
