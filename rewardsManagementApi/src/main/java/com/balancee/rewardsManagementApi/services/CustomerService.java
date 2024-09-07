package com.balancee.rewardsManagementApi.services;


import com.balancee.rewardsManagementApi.data.models.Customer;
import com.balancee.rewardsManagementApi.dtos.requests.CreateCustomerRequest;
import com.balancee.rewardsManagementApi.dtos.responses.CreateCustomerResponse;
import com.balancee.rewardsManagementApi.exceptions.CustomerNotFoundException;


public interface CustomerService {
    CreateCustomerResponse register(CreateCustomerRequest request);

    Customer getCustomerById(long customerId) throws CustomerNotFoundException;

    Customer getCustomerByUsername(String username) throws CustomerNotFoundException;
}
