package com.example.travelbookingapplication3.dto.customer;

import com.example.travelbookingapplication3.dto.BookingDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerCreateRequest {

    private String username;
    private String password;

    private String email;

    private String firstName;
    private String lastName;


    private BookingDto booking;
}
