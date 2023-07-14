package com.example.travelbookingapplication3.dto.rentalcar;

import com.example.travelbookingapplication3.dto.BookingDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RentalCarUpdateRequest {

    private String brand;

    private String model;

    private String rentalCompany;
    private String price;


    private BookingDto booking;
}
