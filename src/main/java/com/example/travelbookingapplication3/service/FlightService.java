package com.example.travelbookingapplication3.service;

import com.example.travelbookingapplication3.error.NotFoundObjectException;
import com.example.travelbookingapplication3.model.Flight;
import com.example.travelbookingapplication3.repository.FlightPagingRepository;
import com.example.travelbookingapplication3.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class FlightService {

    @Autowired
    private FlightRepository repo;

    @Autowired
    private FlightPagingRepository pagingRepo;


    public Page<Flight> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Flight book(Flight flight){
        return repo.save(flight);

    }

    public void deleteById(String flightId){
        repo.deleteById(UUID.fromString(flightId));
    }
    public Flight findById(String flightId) {
        return repo.findById(UUID.fromString(flightId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Flight Not Found", Flight.class.getName(), flightId );
        });
    }
}
