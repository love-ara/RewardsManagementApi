package com.balancee.rewardsManagementApi.services;

import com.balancee.rewardsManagementApi.data.models.CashbackTransaction;
import com.balancee.rewardsManagementApi.data.models.CustomerRewardsData;
import com.balancee.rewardsManagementApi.data.repositories.CashbackTransactionRepository;
import com.balancee.rewardsManagementApi.data.repositories.CustomerRewardsDataRepository;
import com.balancee.rewardsManagementApi.dtos.requests.GetCashbackHistoryRequest;
import com.balancee.rewardsManagementApi.dtos.requests.GetRewardsBalanceRequest;
import com.balancee.rewardsManagementApi.dtos.responses.GetCashbackHistoryResponse;
import com.balancee.rewardsManagementApi.dtos.responses.GetRewardsBalanceResponse;
import com.balancee.rewardsManagementApi.exceptions.CustomerNotFoundException;
import com.balancee.rewardsManagementApi.exceptions.RewardsDataNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardsServiceImplementation implements RewardsService {
    private final ModelMapper modelMapper;
    private final CashbackTransactionRepository transactionRepository;
    private final CustomerRewardsDataRepository rewardsRepository;

    @Autowired
    public RewardsServiceImplementation(CustomerRewardsDataRepository rewardsRepository,
                                        CashbackTransactionRepository transactionRepository,
                                        ModelMapper modelMapper) {
        this.rewardsRepository = rewardsRepository;
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public GetRewardsBalanceResponse getRewardsBalance(GetRewardsBalanceRequest getRewardsBalanceRequest)
            throws CustomerNotFoundException {
        CustomerRewardsData rewardBalance= getRewardsDataBy(getRewardsBalanceRequest.getCustomerId());

        return modelMapper.map(rewardBalance, GetRewardsBalanceResponse.class);
    }

    private CustomerRewardsData getRewardsDataBy(long customerId) {
        return rewardsRepository.findByCustomerId(customerId);
    }

    @Override
    public List<GetCashbackHistoryResponse> getCashbackHistory(GetCashbackHistoryRequest getCashbackHistoryRequest) {
        List<CashbackTransaction> cashTransactions = getCashbackTransactions(getCashbackHistoryRequest.getCustomerId());

        return mapTransactionsToResponse(cashTransactions);
    }

    private List<GetCashbackHistoryResponse> mapTransactionsToResponse(List<CashbackTransaction> cashTransactions) {
    return cashTransactions.stream()
            .map(transaction -> modelMapper.map(transaction, GetCashbackHistoryResponse.class))
            .toList();
    }

    private List<CashbackTransaction> getCashbackTransactions(long customerId) {
        return transactionRepository.findAllTransactionsFor(customerId);
    }
}
