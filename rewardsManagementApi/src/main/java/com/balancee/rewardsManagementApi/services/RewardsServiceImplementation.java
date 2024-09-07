package com.balancee.rewardsManagementApi.services;

import com.balancee.rewardsManagementApi.data.models.CustomerRewardsData;
import com.balancee.rewardsManagementApi.data.repositories.CashbackTransactionRepository;
import com.balancee.rewardsManagementApi.data.repositories.CustomerRewardsDataRepository;
import com.balancee.rewardsManagementApi.dtos.requests.GetCashbackHistoryRequest;
import com.balancee.rewardsManagementApi.dtos.requests.GetRewardsBalanceRequest;
import com.balancee.rewardsManagementApi.dtos.responses.GetCashbackHistoryResponse;
import com.balancee.rewardsManagementApi.dtos.responses.GetRewardsBalanceResponse;
import com.balancee.rewardsManagementApi.exceptions.RewardsDataNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardsServiceImplementation implements RewardsService {
    private final ModelMapper modelMapper = new ModelMapper();
    private CashbackTransactionRepository transactionRepository;
    private final CustomerRewardsDataRepository rewardsRepository;

    @Autowired
    public RewardsServiceImplementation(CustomerRewardsDataRepository rewardsRepository) {
        this.rewardsRepository = rewardsRepository;
    }


    @Override
    public GetRewardsBalanceResponse getRewardsBalance(GetRewardsBalanceRequest getRewardsBalanceRequest) {
        CustomerRewardsData rewardBalance= getRewardsDataBy(getRewardsBalanceRequest.getCustomerId());

        return modelMapper.map(rewardBalance, GetRewardsBalanceResponse.class);
    }

    private CustomerRewardsData getRewardsDataBy(long customerId) {
        return rewardsRepository.findById(customerId)
                .orElseThrow(()-> new RewardsDataNotFoundException("Rewards does not exist"));
    }

    @Override
    public List<GetCashbackHistoryResponse> getCashbackHistory(GetCashbackHistoryRequest getCashbackHistoryRequest) {
        return null;
    }
}
