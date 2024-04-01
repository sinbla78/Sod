package com.example.sod.domain.user.service;

import com.example.sod.domain.auth.domain.RefreshToken;
import com.example.sod.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.sod.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.sod.domain.user.domain.User;
import com.example.sod.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LogoutService {

    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void execute() {
        User user = userFacade.getCurrentUser();

        RefreshToken refreshToken = refreshTokenRepository.findById(user.getAccountId())
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        refreshTokenRepository.delete(refreshToken);
    }
}
