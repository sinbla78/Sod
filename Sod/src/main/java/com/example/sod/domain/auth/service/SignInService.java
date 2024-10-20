package com.example.sod.domain.auth.service;

import com.example.sod.domain.auth.controller.dto.request.SignInRequest;
import com.example.sod.domain.auth.controller.dto.response.TokenResponse;
import com.example.sod.domain.auth.exception.PasswordMisMatchException;
import com.example.sod.domain.user.domain.User;
import com.example.sod.domain.user.domain.repository.UserRepository;
import com.example.sod.domain.user.exception.UserNotFoundException;
import com.example.sod.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(SignInRequest request) {
        // 1. 사용자 조회
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        // 2. 비밀번호 검증
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        // 3. 마지막 로그인 시간 갱신
        user.updateLastLoginTime();  // 마지막 로그인 시간 갱신
        userRepository.save(user);    // DB에 저장

        // 4. JWT 토큰 생성
        String accessToken = jwtTokenProvider.generateAccessToken(request.getAccountId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getAccountId());

        // 5. TokenResponse 반환
        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
