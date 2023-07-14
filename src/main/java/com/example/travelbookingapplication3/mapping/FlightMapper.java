package com.example.travelbookingapplication3.mapping;


import com.example.travelbookingapplication3.dto.booking.BookingCreateRequest;
import com.example.travelbookingapplication3.dto.booking.BookingResponse;
import com.example.travelbookingapplication3.dto.booking.BookingUpdateRequest;
import com.example.travelbookingapplication3.dto.flight.FlightCreateRequest;
import com.example.travelbookingapplication3.dto.flight.FlightResponse;
import com.example.travelbookingapplication3.dto.flight.FlightUpdateRequest;
import com.example.travelbookingapplication3.model.Booking;
import com.example.travelbookingapplication3.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {BookingMapperDto.class})
public interface FlightMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "booking",  ignore = true)
    Flight modelFromCreateRequest(FlightCreateRequest flightCreateDto);

    FlightResponse responseFromModel(Flight flight);
    @Mapping(target = "booking",  ignore = true)
    @Mapping(target = "airline",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "departureAirport", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "arrivalAirport", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "departureTime", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "arrivalTime", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "price", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(FlightUpdateRequest flightUpdateDto, @MappingTarget Flight flight);


    List<FlightResponse> listOfModelToListOfDto(List<Flight>flights);

    List<FlightResponse> listOfModelToListOfDto(Iterable<Flight> all);
}
