package com.example.sod.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank(message = "계정 아이디는 Null, 공백, 띄어쓰기를가 불가합니다.")
    private String accountId;

    @NotBlank(message = "비밀번호은 Null, 공백, 띄어쓰기가 불가합니다.")
    private String password;

    @NotBlank(message = "이메일은 Null, 공백, 띄어쓰기가 불가합니다.")
    private String email;
}
