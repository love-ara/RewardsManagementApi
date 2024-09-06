package com.balancee.rewardsManagementApi.data.repositories;

import com.balancee.rewardsManagementApi.data.models.CashbackTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashbackTransactionRepository extends JpaRepository<CashbackTransaction, Long> {

}
