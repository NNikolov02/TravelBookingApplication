package com.example.travelbookingapplication3.mapping;


import com.example.travelbookingapplication3.dto.UserDto;
import com.example.travelbookingapplication3.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapperDto {

    UserDto modelRoDto(Customer customer);

   Customer dtoModel(Customer customerDto);
}
