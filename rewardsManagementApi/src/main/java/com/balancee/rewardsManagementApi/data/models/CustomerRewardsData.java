package com.balancee.rewardsManagementApi.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Table(name="CustomerRewards")
@NoArgsConstructor
public class CustomerRewardsData {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long customerId;
    private BigDecimal totalCashBack;
    private BigDecimal currentBalance;
}
