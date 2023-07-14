package com.example.travelbookingapplication3.mapping;


import com.example.travelbookingapplication3.dto.rentalcar.RentalCarCreateRequest;
import com.example.travelbookingapplication3.dto.rentalcar.RentalCarResponse;
import com.example.travelbookingapplication3.dto.rentalcar.RentalCarUpdateRequest;
import com.example.travelbookingapplication3.model.RentalCar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {BookingMapperDto.class})
public interface RentalCarMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "booking",  ignore = true)
    RentalCar modelFromCreateRequest(RentalCarCreateRequest rentalCarCreateDto);

    RentalCarResponse responseFromModel(RentalCar rentalCar);
    @Mapping(target = "booking",  ignore = true)
    @Mapping(target = "brand",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "model", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "rentalCompany", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "price", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(RentalCarUpdateRequest rentalCarUpdateDto, @MappingTarget RentalCar rentalCar);


    List<RentalCarResponse> listOfModelToListOfDto(List<RentalCar>rentalCars);

    List<RentalCarResponse> listOfModelToListOfDto(Iterable<RentalCar> all);
}




