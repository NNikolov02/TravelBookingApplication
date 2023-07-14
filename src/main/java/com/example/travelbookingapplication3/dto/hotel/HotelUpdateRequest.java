package com.example.travelbookingapplication3.dto.hotel;

import com.example.travelbookingapplication3.dto.BookingDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelUpdateRequest {

    private String name;
    private  String location;
    private String amenities;

    private String price;

    private BookingDto booking;
}
