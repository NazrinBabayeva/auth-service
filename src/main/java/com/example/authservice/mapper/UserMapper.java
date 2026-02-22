package com.example.authservice.mapper;

import com.example.authservice.model.dto.request.UserRequestDto;
import com.example.authservice.model.dto.response.UserResponseDto;
import com.example.authservice.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRequestDto toUserDto(User user);

    User toEntity(UserRequestDto dto);

    UserResponseDto toResponseDto(User user);

    User toEntity(UserResponseDto dto);
}
