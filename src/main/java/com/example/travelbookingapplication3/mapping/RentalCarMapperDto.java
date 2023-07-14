package com.example.travelbookingapplication3.mapping;


import com.example.travelbookingapplication3.dto.HotelDto;
import com.example.travelbookingapplication3.dto.RentalCarDto;
import com.example.travelbookingapplication3.model.Hotel;
import com.example.travelbookingapplication3.model.RentalCar;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RentalCarMapperDto {

    RentalCarDto modelRoDto(RentalCar rentalCar);

    RentalCar dtoModel(RentalCar rentalCarDto);
}
