package com.example.travelbookingapplication3.dto.rentalcar;

import com.example.travelbookingapplication3.dto.BookingDto;
import com.example.travelbookingapplication3.model.Booking;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RentalCarCreateRequest {

    private String brand;

    private String model;

    private String rentalCompany;
    private String price;


    private BookingDto booking;
}

