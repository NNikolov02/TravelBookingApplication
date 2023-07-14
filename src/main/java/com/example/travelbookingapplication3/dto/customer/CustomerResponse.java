package com.example.travelbookingapplication3.dto.customer;

import com.example.travelbookingapplication3.dto.BookingDto;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CustomerResponse {

    private UUID id;

    private String username;
    private String password;

    private String email;

    private String firstName;
    private String lastName;


    private BookingDto booking;
}
