package com.example.travelbookingapplication3.dto.flight;

import com.example.travelbookingapplication3.dto.BookingDto;
import com.example.travelbookingapplication3.model.Booking;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class FlightCreateRequest {



    private String airline;
    private String departureAirport;

    private String arrivalAirport;

    private String departureTime;

    private String arrivalTime;

    private  String price;


    private BookingDto booking;
}
