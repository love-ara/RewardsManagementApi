package com.balancee.rewardsManagementApi.controllers;

import com.balancee.rewardsManagementApi.dtos.requests.GetCashbackHistoryRequest;
import com.balancee.rewardsManagementApi.dtos.requests.GetRewardsBalanceRequest;
import com.balancee.rewardsManagementApi.services.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {
    private final RewardsService rewardsService;


    @Autowired
    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    @GetMapping("/balance")
    public ResponseEntity<?> getRewardsBalance(@RequestBody GetRewardsBalanceRequest request){
       return ResponseEntity.ok(rewardsService.getRewardsBalance(request));
    }

    @GetMapping("/history")
    public ResponseEntity<?> getCashbackHistory(@RequestBody GetCashbackHistoryRequest request){
        return ResponseEntity.ok(rewardsService.getCashbackHistory(request));
    }

}
