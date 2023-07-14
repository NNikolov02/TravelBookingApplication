package com.example.travelbookingapplication3.service;

import com.example.travelbookingapplication3.error.NotFoundObjectException;
import com.example.travelbookingapplication3.model.Customer;
import com.example.travelbookingapplication3.model.RentalCar;
import com.example.travelbookingapplication3.repository.RentalCarPagingRepository;
import com.example.travelbookingapplication3.repository.RentalCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class RentalCarService {

    @Autowired
    private RentalCarRepository repo;

    @Autowired
        private RentalCarPagingRepository pagingRepo;


    public Page<RentalCar> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public RentalCar book(RentalCar rentalCar){
        return repo.save(rentalCar);

    }

    public void deleteById(String rentalcarId){
        repo.deleteById(UUID.fromString(rentalcarId));
    }
    public RentalCar findById(String rentalcarId) {
        return repo.findById(UUID.fromString(rentalcarId)).orElseThrow(() -> {
            throw new NotFoundObjectException("RentalCar Not Found", Customer.class.getName(), rentalcarId );
        });
    }
}
