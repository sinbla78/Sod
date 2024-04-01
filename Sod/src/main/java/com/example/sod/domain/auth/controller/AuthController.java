package com.example.sod.domain.auth.controller;

import com.example.sod.domain.auth.controller.dto.request.SignInRequest;
import com.example.sod.domain.auth.controller.dto.response.TokenResponse;
import com.example.sod.domain.auth.service.SignInService;
import com.example.sod.domain.auth.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final TokenService tokenService;
    private final SignInService signInService;

    @PutMapping("/token")
    public TokenResponse userTokenRefresh(@RequestHeader("Refresh-Token") String refreshToken) {
        return tokenService.execute(refreshToken);
    }

    @PostMapping("/login")
    public TokenResponse signIn(@RequestBody @Valid SignInRequest signInRequest) {
        return signInService.execute(signInRequest);
    }
}
