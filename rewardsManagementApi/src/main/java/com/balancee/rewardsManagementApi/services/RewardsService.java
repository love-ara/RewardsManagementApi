package com.balancee.rewardsManagementApi.services;

import com.balancee.rewardsManagementApi.dtos.requests.GetCashbackHistoryRequest;
import com.balancee.rewardsManagementApi.dtos.requests.GetRewardsBalanceRequest;
import com.balancee.rewardsManagementApi.dtos.responses.GetCashbackHistoryResponse;
import com.balancee.rewardsManagementApi.dtos.responses.GetRewardsBalanceResponse;

public interface RewardsService {

    GetRewardsBalanceResponse  getRewardsBalance(GetRewardsBalanceRequest getRewardsBalanceRequest);
    GetCashbackHistoryResponse getCashbackHistory(GetCashbackHistoryRequest getCashbackHistoryRequest);

}
