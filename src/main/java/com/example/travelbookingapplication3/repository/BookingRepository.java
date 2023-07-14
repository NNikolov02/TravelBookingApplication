package com.example.travelbookingapplication3.repository;

import com.example.travelbookingapplication3.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookingRepository extends CrudRepository<Booking, UUID> {

}
