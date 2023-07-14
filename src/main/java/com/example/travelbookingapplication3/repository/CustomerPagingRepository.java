package com.example.travelbookingapplication3.repository;

import com.example.travelbookingapplication3.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerPagingRepository extends PagingAndSortingRepository<Customer, UUID> {

}