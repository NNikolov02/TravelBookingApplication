package com.example.travelbookingapplication3.web;

import com.example.travelbookingapplication3.dto.hotel.HotelApiPage;
import com.example.travelbookingapplication3.dto.hotel.HotelCreateRequest;
import com.example.travelbookingapplication3.dto.hotel.HotelResponse;
import com.example.travelbookingapplication3.error.InvalidObjectException;
import com.example.travelbookingapplication3.mapping.HotelMapper;
import com.example.travelbookingapplication3.model.Hotel;
import com.example.travelbookingapplication3.service.HotelService;
import com.example.travelbookingapplication3.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/hotel")
@AllArgsConstructor
@NoArgsConstructor
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private ObjectValidator validator;

    private final Integer Page_Size = 10;

    @GetMapping(name = "", produces = "application/json")
    public HotelApiPage<HotelResponse> getAllHotels(

            @RequestParam(required = false, defaultValue = "0") Integer currPage) {
        Page<HotelResponse> hotelsPage =
                hotelService.fetchAll(currPage, Page_Size).map(hotelMapper::responseFromModel);
        return new  HotelApiPage<>(hotelsPage);


    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelResponse> searchById(@PathVariable String hotelId){
        Hotel hotel = hotelService.findById(hotelId);

        return  ResponseEntity.ok(hotelMapper.responseFromModel(hotel));

    }

    @DeleteMapping("/{hotelId}")
    public void deleteById(@PathVariable String hotelId){
        hotelService.deleteById(hotelId);
    }

    @PostMapping("")
    public ResponseEntity<HotelResponse> bookHotel(@RequestBody HotelCreateRequest hotelDto){
        Map<String, String> validationErrors = validator.validate(hotelDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Hotel Create", validationErrors);
        }

        Hotel hotelCreate = hotelMapper.modelFromCreateRequest(hotelDto);

        Hotel bookHotel = hotelService.book(hotelCreate);

        HotelResponse hotelResponse = hotelMapper.responseFromModel(bookHotel);

        return ResponseEntity.status(201).body(hotelResponse);


    }
}
