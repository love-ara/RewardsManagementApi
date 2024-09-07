package com.balancee.rewardsManagementApi.data.repositories;

import com.balancee.rewardsManagementApi.data.models.CashbackTransaction;
import com.balancee.rewardsManagementApi.exceptions.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@Sql(scripts = {"/database/data.sql"})
@Slf4j
public class CashbackTransactionRepositoryTest {
    @Autowired
    private CashbackTransactionRepository transactionRepository;

    @Test
    public void testFindAllMediaFor() throws CustomerNotFoundException {
        List<CashbackTransaction> transactions = transactionRepository.findAllTransactionsFor(200L);
        log.info("Transaction found: {}", transactions);
        assertThat(transactions).hasSize(1);
    }

}