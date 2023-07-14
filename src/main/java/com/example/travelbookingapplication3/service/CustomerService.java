package com.example.travelbookingapplication3.service;

import com.example.travelbookingapplication3.error.NotFoundObjectException;
import com.example.travelbookingapplication3.model.Customer;
import com.example.travelbookingapplication3.repository.CustomerPagingRepository;
import com.example.travelbookingapplication3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Autowired
    private CustomerPagingRepository pagingRepo;


    public Page<Customer> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Customer registration(Customer customer){
        return repo.save(customer);

    }

    public void deleteById(String customerId){
        repo.deleteById(UUID.fromString(customerId));
    }
    public Customer findById(String customerId) {
        return repo.findById(UUID.fromString(customerId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Customer Not Found", Customer.class.getName(), customerId );
        });
    }

}
