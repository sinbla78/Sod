package com.example.sod.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UpdateInfoRequest {

    @NotBlank(message = "password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+-=?/])[a-zA-Z0-9~!@#$%^&*()_+-=?/]{8,30}$", message = "password는 8-30자여야합니다.")
    private String password;

    @NotBlank(message = "이메일은 Null, 공백, 띄어쓰기가 불가합니다.")
    @Email(message = "email 형식에 맞춰주세요")
    private String email;
}
