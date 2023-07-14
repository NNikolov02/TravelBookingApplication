package com.example.travelbookingapplication3.mapping;


import com.example.travelbookingapplication3.dto.FlightDto;
import com.example.travelbookingapplication3.dto.HotelDto;
import com.example.travelbookingapplication3.model.Flight;
import com.example.travelbookingapplication3.model.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HotelMapperDto {
    HotelDto modelRoDto(Hotel hotel);

    Hotel dtoModel(Hotel hotelDto);
}
