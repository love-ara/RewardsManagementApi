package com.balancee.rewardsManagementApi.data.repositories;

import com.balancee.rewardsManagementApi.data.models.CustomerRewardsData;
import com.balancee.rewardsManagementApi.exceptions.CustomerNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRewardsDataRepository extends JpaRepository<CustomerRewardsData, Long> {
        @Query("SELECT c FROM CustomerRewardsData  c WHERE c.customer.customerId=:customerId")
        CustomerRewardsData findByCustomerId(Long customerId) throws CustomerNotFoundException;


}
