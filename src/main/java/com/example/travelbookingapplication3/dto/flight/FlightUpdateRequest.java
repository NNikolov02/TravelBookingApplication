package com.example.travelbookingapplication3.dto.flight;

import com.example.travelbookingapplication3.dto.BookingDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightUpdateRequest {

    private String airline;
    private String departureAirport;

    private String arrivalAirport;

    private String departureTime;

    private String arrivalTime;

    private  String price;


    private BookingDto booking;
}
