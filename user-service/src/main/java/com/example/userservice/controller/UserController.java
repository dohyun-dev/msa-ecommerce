package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.vo.UserRequest;
import com.example.userservice.vo.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private Greeting greeting;
    private final Environment env;
    private final UserService userService;

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(userRequest, UserDto.class);
        userService.createUser(userDto);
        UserResponse response = mapper.map(userDto, UserResponse.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}