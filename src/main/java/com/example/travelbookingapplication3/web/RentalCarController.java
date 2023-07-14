package com.example.travelbookingapplication3.web;

import com.example.travelbookingapplication3.dto.hotel.HotelApiPage;
import com.example.travelbookingapplication3.dto.hotel.HotelCreateRequest;
import com.example.travelbookingapplication3.dto.hotel.HotelResponse;
import com.example.travelbookingapplication3.dto.rentalcar.RentalCarApiPage;
import com.example.travelbookingapplication3.dto.rentalcar.RentalCarCreateRequest;
import com.example.travelbookingapplication3.dto.rentalcar.RentalCarResponse;
import com.example.travelbookingapplication3.error.InvalidObjectException;
import com.example.travelbookingapplication3.mapping.HotelMapper;
import com.example.travelbookingapplication3.mapping.RentalCarMapper;
import com.example.travelbookingapplication3.model.Hotel;
import com.example.travelbookingapplication3.model.RentalCar;
import com.example.travelbookingapplication3.service.HotelService;
import com.example.travelbookingapplication3.service.RentalCarService;
import com.example.travelbookingapplication3.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rentalCars")
@AllArgsConstructor
@NoArgsConstructor
public class RentalCarController {

    @Autowired
    private RentalCarService rentalCarService;

    @Autowired
    private RentalCarMapper rentalCarMapper;

    @Autowired
    private ObjectValidator validator;

    private final Integer Page_Size = 10;

    @GetMapping(name = "", produces = "application/json")
    public RentalCarApiPage<RentalCarResponse> getAllCars(

            @RequestParam(required = false, defaultValue = "0") Integer currPage) {
        Page<RentalCarResponse> carsPage =
                rentalCarService.fetchAll(currPage, Page_Size).map(rentalCarMapper::responseFromModel);
        return new  RentalCarApiPage<>(carsPage);


    }

    @GetMapping("/{rentalCarId}")
    public ResponseEntity<RentalCarResponse> searchById(@PathVariable String rentalCarId){
       RentalCar rentalCar = rentalCarService.findById(rentalCarId);

        return  ResponseEntity.ok(rentalCarMapper.responseFromModel(rentalCar));

    }

    @DeleteMapping("/{rentalCarId}")
    public void deleteById(@PathVariable String rentalCarId){
        rentalCarService.deleteById(rentalCarId);
    }

    @PostMapping("")
    public ResponseEntity<RentalCarResponse> rentCar(@RequestBody RentalCarCreateRequest rentalCarDto){
        Map<String, String> validationErrors = validator.validate(rentalCarDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Car Rent", validationErrors);
        }

        RentalCar rentalCarCreate = rentalCarMapper.modelFromCreateRequest(rentalCarDto);

        RentalCar rentCar = rentalCarService.book(rentalCarCreate);

        RentalCarResponse rentalCarResponse = rentalCarMapper.responseFromModel(rentCar);

        return ResponseEntity.status(201).body(rentalCarResponse);


    }
}
