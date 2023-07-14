package com.example.travelbookingapplication3.web;

import com.example.travelbookingapplication3.dto.*;
import com.example.travelbookingapplication3.dto.booking.BookingApiPage;
import com.example.travelbookingapplication3.dto.booking.BookingCreateRequest;
import com.example.travelbookingapplication3.dto.booking.BookingResponse;
import com.example.travelbookingapplication3.error.InvalidObjectException;
import com.example.travelbookingapplication3.mapping.BookingMapper;
import com.example.travelbookingapplication3.model.Booking;
import com.example.travelbookingapplication3.service.BookingService;
import com.example.travelbookingapplication3.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ObjectValidator validator;


    private final Integer Page_Size = 10;

    @GetMapping(name = "", produces = "application/json")
    public BookingApiPage<BookingResponse> getAllBookings(

            @RequestParam(required = false, defaultValue = "0") Integer currPage) {
        Page<BookingResponse> bookingsPage =
               bookingService.fetchAll(currPage, Page_Size).map(bookingMapper::responseFromModel);
        return new  BookingApiPage<>(bookingsPage);


    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingResponse>findBooking(@PathVariable String bookingId){
        Booking booking = bookingService.findById(bookingId);

        return ResponseEntity.ok(bookingMapper.responseFromModel(booking));
    }

    @DeleteMapping("/{bookingId}")
    public void  deleteById(@PathVariable String bookingId){

        bookingService.deleteById(bookingId);
    }

    @PostMapping("")
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingCreateRequest bookingDto){

        Map<String, String> validationErrors = validator.validate(bookingDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Booking Create", validationErrors);
        }

        Booking createBooking = bookingMapper.modelFromCreateRequest(bookingDto);

        Booking save = bookingService.create(createBooking);

        BookingResponse bookingResponse = bookingMapper.responseFromModel(save);


        return ResponseEntity.status(201).body(bookingResponse);
    }

    @PutMapping(value = "/{bookingId}/customers")
    public BookingCustomersResponse setAllBookingUsers(@PathVariable String bookingId, @RequestBody SetCustomerRequest customers) {

        Set<UUID> bookingCustomers = bookingService.setBookingCustomer(bookingId, customers.getSetCustomers());

        BookingCustomersResponse result = BookingCustomersResponse.builder().BookingCustomersIds(bookingCustomers).build();

        return result;
    }

    @PutMapping(value = "/{bookingId}/hotels")
    public BookingHotelsResponse setAllBookingHotels(@PathVariable String bookingId, @RequestBody SetHotelRequest hotels) {

        Set<UUID> bookingHotels = bookingService.setBookingHotel(bookingId, hotels.getSetHotels());

        BookingHotelsResponse result = BookingHotelsResponse.builder().BookingHotelIds(bookingHotels).build();

        return result;
    }


    @PutMapping(value = "/{bookingId}/rentalCars")
    public BookingRentalCarResponse setAllBookingRentalCars(@PathVariable String rentalCarId, @RequestBody SetRentCarRequest rentalCar) {

        Set<UUID> bookingRentalCars = bookingService.setBookingRentalCar(rentalCarId, rentalCar.getSetRentalCars());

        BookingRentalCarResponse result = BookingRentalCarResponse.builder().BookingRentalCarIds(bookingRentalCars).build();

        return result;
    }

    @PutMapping(value = "/{personId}/starships")
    public BookingFlightsResponse setAllBookingFlights(@PathVariable String bookingId, @RequestBody SetFlightRequest flights) {

        Set<UUID>bookingFlights = bookingService.setBookingFlight(bookingId, flights.getSetFlights());

        BookingFlightsResponse result = BookingFlightsResponse.builder().BookingFlightIds(bookingFlights).build();

        return result;
    }
}
