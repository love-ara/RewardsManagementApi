package com.balancee.rewardsManagementApi.data.repositories;

import com.balancee.rewardsManagementApi.data.models.CustomerRewardsData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRewardsDataRepository extends JpaRepository<CustomerRewardsData, Long> {
    Optional<CustomerRewardsData> findByCustomerId(Long customerId);
}
