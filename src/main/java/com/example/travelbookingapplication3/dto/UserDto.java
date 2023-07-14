package com.example.travelbookingapplication3.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserDto {

    private UUID id;

    private String username;
    private String password;

    private String email;

    private String firstName;
    private String lastName;
}
