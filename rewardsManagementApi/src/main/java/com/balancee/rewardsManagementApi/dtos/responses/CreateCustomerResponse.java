package com.balancee.rewardsManagementApi.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerResponse {
    private String email;
    private String customerId;
    private String message;
}
