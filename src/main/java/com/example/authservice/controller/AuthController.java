package com.example.authservice.controller;


import com.example.authservice.config.JwtUtils;
import com.example.authservice.model.dto.request.UserRequestDto;
import com.example.authservice.model.dto.response.UserResponseDto;
import com.example.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody UserRequestDto dto) {

        UserResponseDto savedUser = userService.signup(dto);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequestDto dto) {

        UserResponseDto user = userService.login(dto.getEmail(), dto.getPassword());
        String token = jwtUtils.generateToken(user.getEmail());

        return ResponseEntity.ok(token);
    }

}

