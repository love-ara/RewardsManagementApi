package com.balancee.rewardsManagementApi.services;

import com.balancee.rewardsManagementApi.data.repositories.CashbackTransactionRepository;
import com.balancee.rewardsManagementApi.data.repositories.CustomerRewardsDataRepository;
import com.balancee.rewardsManagementApi.dtos.requests.GetCashbackHistoryRequest;
import com.balancee.rewardsManagementApi.dtos.requests.GetRewardsBalanceRequest;
import com.balancee.rewardsManagementApi.dtos.responses.GetCashbackHistoryResponse;
import com.balancee.rewardsManagementApi.dtos.responses.GetRewardsBalanceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RewardsServiceImplementation implements RewardsService {
    private final ModelMapper modelMapper = new ModelMapper();
    private CashbackTransactionRepository transactionRepository;
    private CustomerRewardsDataRepository rewardsRepository;
    @Override
    public GetRewardsBalanceResponse getRewardsBalance(GetRewardsBalanceRequest getRewardsBalanceRequest) {
        return null;
    }

    @Override
    public GetCashbackHistoryResponse getCashbackHistory(GetCashbackHistoryRequest getCashbackHistoryRequest) {
        return null;
    }
}
