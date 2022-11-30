package com.example.userservice.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserRequest {

    @NotBlank(message = "이메일을 입력해주세요.")
    @Size(min = 2, message = "이메일은 2글자 이상이어야 합니다.")
    private String email;

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(min = 2, message = "이름은 2글자 이상이어야 합니다.")
    private String name;

    @NotBlank(message = "패스워드를 입력해주세요.")
    @Size(min = 8, message = "패스워드는 8글자 이상이어야 합니다.")
    private String pwd;
}
