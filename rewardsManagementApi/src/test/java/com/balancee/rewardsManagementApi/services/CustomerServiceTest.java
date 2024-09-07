package com.balancee.rewardsManagementApi.services;

import static org.junit.jupiter.api.Assertions.*;

import com.balancee.rewardsManagementApi.data.models.Customer;
import com.balancee.rewardsManagementApi.dtos.requests.CreateCustomerRequest;
import com.balancee.rewardsManagementApi.dtos.responses.CreateCustomerResponse;
import com.balancee.rewardsManagementApi.exceptions.CustomerNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Sql(scripts = {"/database/data.sql"})
public class CustomerServiceTest {

    @Autowired
    public CustomerService customerService;

    @Test
    public void registerTest() {
        CreateCustomerRequest request = new CreateCustomerRequest();
        request.setEmail("email@email.com");
        request.setPassword("password");

        CreateCustomerResponse response= customerService.register(request);
        assertNotNull(response);
        assertTrue(response.getMessage().contains("success"));

    }

    @Test
    @DisplayName("test that user can be retrieved by id")
    public void testGetUserById() throws CustomerNotFoundException {
        Customer customer = customerService.getById(200L);
        assertThat(customer).isNotNull();
    }
}