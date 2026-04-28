package com.performancelog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 로그인 요청 DTO
 * FR-002(로그인) 기능과 연관된다.
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    private String username;
    private String password;
}