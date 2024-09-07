package com.balancee.rewardsManagementApi.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "/database/data.sql")
@WithMockUser(authorities = {"CUSTOMER"})
public class RewardsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllRewards(){
        try{
            String requestBody = "{\"customerId\":200}";
            mockMvc.perform(get("/api/rewards/balance")
                            .content(requestBody)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().is2xxSuccessful())
                    .andExpect(jsonPath("$.customerId").value(200.00))
                    .andExpect(jsonPath("$.totalCashback").value(new BigDecimal("200.0")))
                    .andExpect(jsonPath("$.currentBalance").value(new BigDecimal("50.0")))
                    .andDo(print());
            } catch (Exception e) {
            assertThat(e).isNull();


        }

    }

    @Test
    public void testGetCashbackHistory() throws Exception {
        try {
            String requestBody = "{\"customerId\":200}";

            mockMvc.perform(get("/api/rewards/history")
                            .content(requestBody)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].transactionId").value(1))
                    .andExpect(jsonPath("$[0].amountEarned").value(25.0));

        }catch (Exception e){
            throw e;
        }

    }


    @Test
    public void testGetRewardsBalanceForCustomerShouldFailForInvalidCustomerId() throws Exception{
        String requestBody = "{\"customerId\":300}";

        mockMvc.perform(MockMvcRequestBuilders.get("/api/rewards/balance")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print(System.out))
                .andExpect(status().isBadRequest())
                .andDo(print());


    }
}