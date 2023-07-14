package com.example.travelbookingapplication3.web;


import com.example.travelbookingapplication3.dto.customer.CustomerApiPage;
import com.example.travelbookingapplication3.dto.customer.CustomerCreateRequest;
import com.example.travelbookingapplication3.dto.customer.CustomerResponse;
import com.example.travelbookingapplication3.dto.customer.CustomerUpdateRequest;
import com.example.travelbookingapplication3.error.InvalidObjectException;
import com.example.travelbookingapplication3.mapping.CustomerMapper;
import com.example.travelbookingapplication3.model.Customer;
import com.example.travelbookingapplication3.service.CustomerService;
import com.example.travelbookingapplication3.validation.ObjectValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerService customerService;

    private final Integer Page_Size = 10;

    @GetMapping(name = "", produces = "application/json")
    public CustomerApiPage<CustomerResponse> getAllUsers(

            @RequestParam(required = false, defaultValue = "0") Integer currPage) {
        Page<CustomerResponse> usersPage =
                customerService.fetchAll(currPage, Page_Size).map(customerMapper::responseFromModel);
        return new CustomerApiPage<>(usersPage);


    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse>findUserById(@PathVariable String customerId){

        Customer customer = customerService.findById(customerId);

        return ResponseEntity.ok(customerMapper.responseFromModel(customer));
    }

    @DeleteMapping("/{customerId}")
    public void deleteUserById(@PathVariable String customerId){

        customerService.deleteById(customerId);
    }

    @PostMapping("")
    public ResponseEntity<CustomerResponse>registerUser(@RequestBody CustomerCreateRequest userDto){
        Map<String, String> validationErrors = validator.validate(userDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Customer Create", validationErrors);
        }

        Customer createCustomer = customerMapper.modelFromCreateRequest(userDto);

        Customer save = customerService.registration(createCustomer);

        CustomerResponse userResponse = customerMapper.responseFromModel(save);



        return ResponseEntity.status(201).body(userResponse);
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<CustomerResponse>profileChange(@PathVariable String customerId, @RequestBody CustomerUpdateRequest userDto){
        Map<String, String> validationErrors = validator.validate(userDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid User Update", validationErrors);
        }
        Customer findCustomer = customerService.findById(customerId);

        customerMapper.updateModelFromDto(userDto, findCustomer);

        Customer register = customerService.registration(findCustomer);

        CustomerResponse userResponse = customerMapper.responseFromModel(register);



        return ResponseEntity.status(200).body(userResponse);

    }


}
