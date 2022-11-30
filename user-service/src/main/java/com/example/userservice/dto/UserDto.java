package com.example.userservice.dto;

import com.example.userservice.vo.OrderResponse;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private LocalDateTime createdAt;
    private String encryptedPwd;

    private List<OrderResponse> orders;
}
