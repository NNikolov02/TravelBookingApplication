package com.example.travelbookingapplication3.repository;

import com.example.travelbookingapplication3.model.Flight;
import com.example.travelbookingapplication3.model.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightRepository extends CrudRepository<Flight, UUID> {

}
