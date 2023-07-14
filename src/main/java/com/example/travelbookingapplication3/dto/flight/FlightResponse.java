package com.example.travelbookingapplication3.dto.flight;


import com.example.travelbookingapplication3.dto.BookingDto;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class FlightResponse {

    private UUID id;

    private String airline;
    private String departureAirport;

    private String arrivalAirport;

    private String departureTime;

    private String arrivalTime;

    private  String price;


    private BookingDto booking;
}
