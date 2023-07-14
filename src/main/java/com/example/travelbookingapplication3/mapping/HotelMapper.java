package com.example.travelbookingapplication3.mapping;



import com.example.travelbookingapplication3.dto.hotel.HotelCreateRequest;
import com.example.travelbookingapplication3.dto.hotel.HotelResponse;
import com.example.travelbookingapplication3.dto.hotel.HotelUpdateRequest;
import com.example.travelbookingapplication3.model.Flight;
import com.example.travelbookingapplication3.model.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {BookingMapperDto.class})
public interface HotelMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "booking",  ignore = true)
    Hotel modelFromCreateRequest(HotelCreateRequest hotelCreateDto);

    HotelResponse responseFromModel(Hotel hotel);
    @Mapping(target = "booking",  ignore = true)
    @Mapping(target = "name",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "location", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "amenities", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "price", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(HotelUpdateRequest hotelUpdateDto, @MappingTarget Hotel hotel);


    List<HotelResponse> listOfModelToListOfDto(List<Hotel>hotels);

    List<HotelResponse> listOfModelToListOfDto(Iterable<Hotel> all);
}


