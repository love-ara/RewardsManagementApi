package com.balancee.rewardsManagementApi.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Table(name="customer_rewards")
@NoArgsConstructor
public class CustomerRewardsData {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long rewardId;
    @OneToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    private BigDecimal totalCashback;
    private BigDecimal currentBalance;
}
