package com.example.travelbookingapplication3.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookingDto {

    private UUID id;

    private String passengerDetails;

    private String paymentDetails;

    private String bookingDate;
}
