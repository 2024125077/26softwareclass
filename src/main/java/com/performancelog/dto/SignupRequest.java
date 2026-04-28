package com.performancelog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 회원가입 요청 DTO
 * FR-001(회원가입) 기능과 연관된다.
 */
@Getter
@Setter
@NoArgsConstructor
public class SignupRequest {

    private String username;
    private String password;
    private String email;
}