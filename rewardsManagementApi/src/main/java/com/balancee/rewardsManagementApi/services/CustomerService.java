package com.balancee.rewardsManagementApi.services;


import com.balancee.rewardsManagementApi.data.models.Customer;
import com.balancee.rewardsManagementApi.dtos.requests.CreateCustomerRequest;
import com.balancee.rewardsManagementApi.dtos.responses.CreateCustomerResponse;
import com.balancee.rewardsManagementApi.exceptions.CustomerNotFoundException;


public interface CustomerService {
    CreateCustomerResponse register(CreateCustomerRequest request);

    Customer getById(long customerId) throws CustomerNotFoundException;

    Customer getByUsername(String username) throws CustomerNotFoundException;
}
