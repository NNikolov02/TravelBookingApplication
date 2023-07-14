package com.example.travelbookingapplication3.mapping;


import com.example.travelbookingapplication3.dto.BookingDto;
import com.example.travelbookingapplication3.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface  BookingMapperDto {

    BookingDto modelRoDto(Booking booking);

   Booking dtoModel(Booking bookingDto);
}
