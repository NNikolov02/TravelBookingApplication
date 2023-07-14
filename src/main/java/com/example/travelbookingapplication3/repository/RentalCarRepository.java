package com.example.travelbookingapplication3.repository;

import com.example.travelbookingapplication3.model.Hotel;
import com.example.travelbookingapplication3.model.RentalCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RentalCarRepository extends CrudRepository<RentalCar, UUID> {

}
