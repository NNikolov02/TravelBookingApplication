package com.example.travelbookingapplication3.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class BookingHotelsResponse {

    private Set<UUID> BookingHotelIds;
}
