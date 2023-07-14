package com.example.travelbookingapplication3.dto.hotel;


import com.example.travelbookingapplication3.dto.BookingDto;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class HotelResponse {

    private UUID id;

    private String name;
    private  String location;
    private String amenities;

    private String price;

    private BookingDto booking;
}
