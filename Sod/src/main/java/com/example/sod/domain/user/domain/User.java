package com.example.sod.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String accountId;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String email;

    @Builder
    private User(String accountId, String password, String email) {
        this.accountId = accountId;
        this.password = password;
        this.email = email;
    }
    public void updateUser(String password, String email) {
        this.password = password;
        this.email = email;
    }
}
