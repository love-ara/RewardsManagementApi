package com.balancee.rewardsManagementApi.data.repositories;

import com.balancee.rewardsManagementApi.data.models.CashbackTransaction;
import com.balancee.rewardsManagementApi.exceptions.CustomerNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CashbackTransactionRepository extends JpaRepository<CashbackTransaction, Long> {
    @Query("SELECT c FROM CashbackTransaction c WHERE c.customer.customerId=:customerId")
    List<CashbackTransaction> findAllTransactionsFor(Long customerId) throws CustomerNotFoundException;
}
