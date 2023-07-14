package com.example.travelbookingapplication3.repository;

import com.example.travelbookingapplication3.model.RentalCar;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RentalCarPagingRepository extends PagingAndSortingRepository<RentalCar, UUID> {

}