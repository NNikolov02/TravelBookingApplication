package com.example.travelbookingapplication3.mapping;


import com.example.travelbookingapplication3.dto.booking.BookingCreateRequest;
import com.example.travelbookingapplication3.dto.booking.BookingResponse;
import com.example.travelbookingapplication3.dto.booking.BookingUpdateRequest;
import com.example.travelbookingapplication3.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {FlightMapperDto.class, HotelMapperDto.class, RentalCarMapperDto.class, CustomerMapperDto.class})
public interface BookingMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customers",  ignore = true)
    @Mapping(target = "hotels", ignore = true)
    @Mapping(target = "flights", ignore = true)
    @Mapping(target = "rentalCars", ignore = true)
    Booking modelFromCreateRequest(BookingCreateRequest bookingCreateDto);

    BookingResponse responseFromModel(Booking booking);
    @Mapping(target = "customers",  ignore = true)
    @Mapping(target = "hotels", ignore = true)
    @Mapping(target = "flights", ignore = true)
    @Mapping(target = "rentalCars", ignore = true)
    @Mapping(target = "passengerDetails",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "paymentDetails", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "bookingDate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(BookingUpdateRequest bookingUpdateDto, @MappingTarget Booking booking);


    List<BookingResponse> listOfModelToListOfDto(List<Booking>bookings);

    List<BookingResponse> listOfModelToListOfDto(Iterable<Booking> all);
}
