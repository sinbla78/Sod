package com.example.sod.domain.user.service;


import com.example.sod.domain.user.controller.dto.request.SignUpRequest;
import com.example.sod.domain.user.domain.User;
import com.example.sod.domain.user.domain.repository.UserRepository;
import com.example.sod.domain.user.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRequest signUpRequest) {

        if (userRepository.findByAccountId(signUpRequest.getAccountId()).isPresent()) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        User user = User.builder()
                .accountId(signUpRequest.getAccountId())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .email(signUpRequest.getEmail())
                .build();

        userRepository.save(user);
    }
}
