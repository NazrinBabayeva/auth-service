package com.example.authservice.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String fin;
    private String account;
    private String email;
    private String password;
    private String address;
    private Double accountBalance;
}

