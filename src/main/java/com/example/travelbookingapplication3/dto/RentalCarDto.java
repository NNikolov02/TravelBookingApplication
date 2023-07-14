package com.example.travelbookingapplication3.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RentalCarDto {

    private UUID id;

    private String brand;

    private String model;

    private String rentalCompany;
    private String price;
}
