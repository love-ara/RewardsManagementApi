package com.balancee.rewardsManagementApi.controllers;

import com.balancee.rewardsManagementApi.dtos.requests.GetRewardsBalanceRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

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
                    .andExpect(jsonPath("$.currentBalance").value(new BigDecimal("150.0")))
                    .andDo(print());
            } catch (Exception e) {
            assertThat(e).isNull();


        }

    }
}