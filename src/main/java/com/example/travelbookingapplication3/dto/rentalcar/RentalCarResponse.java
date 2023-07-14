package com.example.travelbookingapplication3.dto.rentalcar;

import com.example.travelbookingapplication3.dto.BookingDto;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RentalCarResponse {

    private UUID id;

    private String brand;

    private String model;

    private String rentalCompany;
    private String price;


    private BookingDto booking;
}
