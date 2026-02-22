package com.example.authservice.service;

import com.example.authservice.model.dto.request.UserRequestDto;
import com.example.authservice.model.dto.response.UserResponseDto;
import com.example.authservice.model.entity.User;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserResponseDto signup(UserRequestDto dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = userMapper.toEntity(dto);   // static yox
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        return userMapper.toResponseDto(userRepository.save(user));
    }

    public UserResponseDto login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return userMapper.toResponseDto(user);
    }
}
