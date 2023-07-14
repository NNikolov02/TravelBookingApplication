package com.example.travelbookingapplication3.mapping;


import com.example.travelbookingapplication3.dto.BookingDto;
import com.example.travelbookingapplication3.dto.FlightDto;
import com.example.travelbookingapplication3.model.Booking;
import com.example.travelbookingapplication3.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FlightMapperDto {

    FlightDto modelRoDto(Flight flight);

    Flight dtoModel(Flight flightDto);
}
