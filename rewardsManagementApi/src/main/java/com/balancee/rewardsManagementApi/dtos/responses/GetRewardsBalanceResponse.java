package com.balancee.rewardsManagementApi.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class GetRewardsBalanceResponse {
    private Long customerId;
    private BigDecimal totalCashback;
    private BigDecimal currentBalance;
}
