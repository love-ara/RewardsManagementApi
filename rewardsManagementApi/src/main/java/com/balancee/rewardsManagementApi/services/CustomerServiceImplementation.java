package com.balancee.rewardsManagementApi.services;


import com.balancee.rewardsManagementApi.data.models.Authority;
import com.balancee.rewardsManagementApi.data.models.Customer;
import com.balancee.rewardsManagementApi.data.repositories.CustomerRepository;
import com.balancee.rewardsManagementApi.dtos.requests.CreateCustomerRequest;
import com.balancee.rewardsManagementApi.dtos.responses.CreateCustomerResponse;
import com.balancee.rewardsManagementApi.exceptions.CustomerNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class CustomerServiceImplementation implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository, ModelMapper modelMapper,
                                         PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CreateCustomerResponse register(CreateCustomerRequest request) {
        Customer customer = modelMapper.map(request, Customer.class);
        customer.setPassword(passwordEncoder.encode(request.getPassword()));
        customer.setAuthorities(new HashSet<>());
        var authorities = customer.getAuthorities();
        authorities.add(Authority.CUSTOMER);

        Customer savedCustomer = customerRepository.save(customer);


        var response = modelMapper.map(savedCustomer, CreateCustomerResponse.class);
        response.setMessage("Customer registered successfully");

        return response;
    }

    @Override
    public Customer getById(long customerId) throws CustomerNotFoundException {

        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with id %d not found", customerId))
        );
    }

    @Override
    public Customer getByUsername(String username) throws CustomerNotFoundException {
        Customer customer = customerRepository.findByEmail(username)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));


        return customer;
    }
}

