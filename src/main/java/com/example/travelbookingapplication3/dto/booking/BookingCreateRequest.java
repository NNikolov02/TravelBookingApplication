package com.example.travelbookingapplication3.dto.booking;

import com.example.travelbookingapplication3.dto.FlightDto;
import com.example.travelbookingapplication3.dto.HotelDto;
import com.example.travelbookingapplication3.dto.RentalCarDto;
import com.example.travelbookingapplication3.dto.UserDto;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class BookingCreateRequest {

    private String passengerDetails;

    private String paymentDetails;

    private String bookingDate;


    private Set<UserDto> users;


    private Set<FlightDto> flights;


    private Set<HotelDto> hotels;



    private Set<RentalCarDto> rentalCars;

}
