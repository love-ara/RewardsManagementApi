package com.balancee.rewardsManagementApi.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class GetCashbackHistoryResponse {
    private Long transactionId;
    private String transactionDate;
    private BigDecimal amountEarned;
    private String description;
}
