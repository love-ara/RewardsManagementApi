package com.balancee.rewardsManagementApi.services;

import com.balancee.rewardsManagementApi.data.repositories.CustomerRewardsDataRepository;
import com.balancee.rewardsManagementApi.dtos.requests.GetCashbackHistoryRequest;
import com.balancee.rewardsManagementApi.dtos.requests.GetRewardsBalanceRequest;
import com.balancee.rewardsManagementApi.dtos.responses.GetCashbackHistoryResponse;
import com.balancee.rewardsManagementApi.dtos.responses.GetRewardsBalanceResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"/database/data.sql"})
public class RewardsServiceImplementationTest {
    @Autowired
    private RewardsService rewardsService;

    @Autowired
    private CustomerRewardsDataRepository rewardsRepository;

    @Test
    public void testThatUserCanGetTheirRewardBalance(){
        GetRewardsBalanceRequest request = new GetRewardsBalanceRequest();
        request.setCustomerId(1L);

        GetRewardsBalanceResponse response = rewardsService.getRewardsBalance(request);

        assertNotNull(response);
        assertEquals(1L, response.getCustomerId());
        assertEquals(new BigDecimal("200.00"), response.getTotalCashback());
        assertEquals(new BigDecimal("50.00"), response.getCurrentBalance());

    }

    @Test
    public void testThatUserCanGetTheirCashbackHistory() {
        GetCashbackHistoryRequest request = new GetCashbackHistoryRequest();
        request.setCustomerId(1L);

        List<GetCashbackHistoryResponse> transactions = rewardsService
                .getCashbackHistory(request);

        assertNotNull(transactions);
        assertEquals(2, transactions.size());

        GetCashbackHistoryResponse firstTransaction = transactions.get(0);
        assertEquals(1L, firstTransaction.getTransactionId());
        assertEquals(25.0, firstTransaction.getAmountEarned());
        assertEquals("Booking #1234", firstTransaction.getDescription());

        GetCashbackHistoryResponse secondTransaction = transactions.get(1);
        assertEquals(2L, secondTransaction.getTransactionId());
        assertEquals(30.0, secondTransaction.getAmountEarned());
        assertEquals("Booking #3456", secondTransaction.getDescription());
    }

}