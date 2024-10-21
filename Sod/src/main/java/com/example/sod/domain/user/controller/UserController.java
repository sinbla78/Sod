package com.example.sod.domain.user.controller;

import com.example.sod.domain.user.controller.dto.request.SignUpRequest;
import com.example.sod.domain.user.controller.dto.request.UpdateInfoRequest;
import com.example.sod.domain.user.controller.dto.request.UpdatePasswordRequest;
import com.example.sod.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final SignUpService signUpService;
    private final WithdrawalService withdrawalService;
    private final UpdateInfoService updateInfoService;
    private final UpdatePasswordService updatePasswordService;
    private final LogoutService logoutService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        signUpService.execute(signUpRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout() {
        logoutService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteUser() {
        withdrawalService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/password")
    public void updatePassword(@RequestBody @Valid UpdatePasswordRequest updatePasswordRequest) {
        updatePasswordService.execute(updatePasswordRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/info")
    public void updateUser(@RequestBody @Valid UpdateInfoRequest updateInfoRequest) {
        updateInfoService.execute(updateInfoRequest);
    }
}
