package com.balancee.rewardsManagementApi.services;

import com.balancee.rewardsManagementApi.dtos.requests.GetCashbackHistoryRequest;
import com.balancee.rewardsManagementApi.dtos.requests.GetRewardsBalanceRequest;
import com.balancee.rewardsManagementApi.dtos.responses.GetCashbackHistoryResponse;
import com.balancee.rewardsManagementApi.dtos.responses.GetRewardsBalanceResponse;

import java.util.List;

public interface RewardsService {

    GetRewardsBalanceResponse  getRewardsBalance(GetRewardsBalanceRequest getRewardsBalanceRequest);
    List<GetCashbackHistoryResponse> getCashbackHistory(GetCashbackHistoryRequest getCashbackHistoryRequest);

}
