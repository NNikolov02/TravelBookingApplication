package com.example.travelbookingapplication3.dto;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class HotelDto {

    private UUID id;

    private String name;
    private  String location;
    private String amenities;

    private String price;
}
