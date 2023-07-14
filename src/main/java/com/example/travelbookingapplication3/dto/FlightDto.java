package com.example.travelbookingapplication3.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class FlightDto {

    private UUID id;

    private String airline;
    private String departureAirport;

    private String arrivalAirport;

    private String departureTime;

    private String arrivalTime;

    private  String price;
}
