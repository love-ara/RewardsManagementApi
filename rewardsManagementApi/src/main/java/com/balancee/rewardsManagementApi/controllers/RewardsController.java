package com.balancee.rewardsManagementApi.controllers;

import com.balancee.rewardsManagementApi.dtos.requests.GetCashbackHistoryRequest;
import com.balancee.rewardsManagementApi.dtos.requests.GetRewardsBalanceRequest;
import com.balancee.rewardsManagementApi.dtos.responses.BaseResponse;
import com.balancee.rewardsManagementApi.exceptions.CustomerNotFoundException;
import com.balancee.rewardsManagementApi.services.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {
    private final RewardsService rewardsService;


    @Autowired
    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @GetMapping("/balance")
    public ResponseEntity<?> getRewardsBalance(@RequestBody GetRewardsBalanceRequest request) throws CustomerNotFoundException {
       return new ResponseEntity<>(new BaseResponse<>(200,true,
               rewardsService.getRewardsBalance(request)), OK);
    }

    @GetMapping("/history")
    public ResponseEntity<?> getCashbackHistory(@RequestBody GetCashbackHistoryRequest request) throws CustomerNotFoundException{
        return new ResponseEntity<>(new BaseResponse<>(200, true,
                rewardsService.getCashbackHistory(request)), OK);
    }

}
