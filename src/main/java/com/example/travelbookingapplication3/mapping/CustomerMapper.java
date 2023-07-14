package com.example.travelbookingapplication3.mapping;


import com.example.travelbookingapplication3.dto.customer.CustomerCreateRequest;
import com.example.travelbookingapplication3.dto.customer.CustomerResponse;
import com.example.travelbookingapplication3.dto.customer.CustomerUpdateRequest;
import com.example.travelbookingapplication3.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {BookingMapperDto.class})
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "booking",  ignore = true)
    Customer modelFromCreateRequest(CustomerCreateRequest userCreateDto);

    CustomerResponse responseFromModel(Customer customer);
    @Mapping(target = "booking",  ignore = true)
    @Mapping(target = "username",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "password", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "email", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "firstName", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "lastName", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(CustomerUpdateRequest userUpdateDto, @MappingTarget Customer customer);


    List<CustomerResponse> listOfModelToListOfDto(List<Customer> customers);

    List<CustomerResponse> listOfModelToListOfDto(Iterable<Customer> all);
}
