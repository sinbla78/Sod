package com.example.sod.domain.user.service;

import com.example.sod.domain.user.controller.dto.request.UpdatePasswordRequest;
import com.example.sod.domain.user.domain.User;
import com.example.sod.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class UpdatePasswordService {

    private final PasswordEncoder passwordEncoder;
    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdatePasswordRequest updatePasswordRequest) {
        // 현재 로그인한 사용자 가져오기
        User user = userFacade.getCurrentUser();

        // 현재 비밀번호가 저장된 비밀번호와 일치하는지 확인
        if (!passwordEncoder.matches(updatePasswordRequest.getCurrentPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "현재 비밀번호가 일치하지 않습니다.");
        }

        // 새 비밀번호가 기존 비밀번호와 동일하지 않은지 확인
        if (updatePasswordRequest.getCurrentPassword().equals(updatePasswordRequest.getNewPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "새 비밀번호가 기존 비밀번호와 동일할 수 없습니다.");
        }

        // 새 비밀번호가 null 또는 빈 값이 아닌지 확인
        if (updatePasswordRequest.getNewPassword() == null || updatePasswordRequest.getNewPassword().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "새 비밀번호는 null 또는 빈 문자열일 수 없습니다.");
        }

        // 새 비밀번호를 암호화해서 업데이트
        user.updatePassword(passwordEncoder.encode(updatePasswordRequest.getNewPassword()));
    }
}
