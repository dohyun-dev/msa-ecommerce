package com.example.userservice.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginRequest {
    @NotBlank(message = "이메일을 입력해주세요.")
    @Size(min = 2, message = "이메일은 2자리 이상이어야 합니다.")
    @Email
    private String email;

    @NotBlank(message = "비밀번호을 입력해주세요.")
    @Size(min = 8, message = "비밀번호는 8자리 이상이어야 합니다.")
    private String password;
}
