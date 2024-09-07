package com.balancee.rewardsManagementApi.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateCustomerRequest {
    private String email;
    private String password;
}
