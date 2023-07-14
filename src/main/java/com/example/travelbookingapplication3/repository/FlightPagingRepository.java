package com.example.travelbookingapplication3.repository;

import com.example.travelbookingapplication3.model.Booking;
import com.example.travelbookingapplication3.model.Flight;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightPagingRepository extends PagingAndSortingRepository<Flight, UUID> {

}
