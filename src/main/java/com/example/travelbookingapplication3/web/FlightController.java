package com.example.travelbookingapplication3.web;

import com.example.travelbookingapplication3.dto.flight.FlightApiPage;
import com.example.travelbookingapplication3.dto.flight.FlightCreateRequest;
import com.example.travelbookingapplication3.dto.flight.FlightResponse;
import com.example.travelbookingapplication3.error.InvalidObjectException;
import com.example.travelbookingapplication3.mapping.FlightMapper;
import com.example.travelbookingapplication3.model.Flight;
import com.example.travelbookingapplication3.service.FlightService;
import com.example.travelbookingapplication3.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/flights")
@AllArgsConstructor
@NoArgsConstructor
public class FlightController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private FlightMapper flightMapper;

    @Autowired
    private FlightService flightService;

    private final Integer Page_Size = 10;

    @GetMapping(name = "", produces = "application/json")
    public FlightApiPage<FlightResponse> getAllFlights(

            @RequestParam(required = false, defaultValue = "0") Integer currPage) {
        Page<FlightResponse> flightsPage =
                flightService.fetchAll(currPage, Page_Size).map(flightMapper::responseFromModel);
        return new  FlightApiPage<>(flightsPage);


    }

    @GetMapping("/{flightsId}")
    public ResponseEntity<FlightResponse> findFlightById(@PathVariable String flightsId){

        Flight flight = flightService.findById(flightsId);

        return ResponseEntity.ok(flightMapper.responseFromModel(flight));
    }

    @DeleteMapping("/{flightsId}")
    public void deleteFlightById(@PathVariable String flightsId){

        flightService.deleteById(flightsId);
    }

    @PostMapping("")
    public ResponseEntity<FlightResponse>bookFlight(@RequestBody FlightCreateRequest flightDto){
        Map<String, String> validationErrors = validator.validate(flightDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Flight Create", validationErrors);
        }

        Flight bookFlight = flightMapper.modelFromCreateRequest(flightDto);

        Flight book = flightService.book(bookFlight);

        FlightResponse flightResponse = flightMapper.responseFromModel(book);



        return ResponseEntity.status(201).body(flightResponse);
    }
}
