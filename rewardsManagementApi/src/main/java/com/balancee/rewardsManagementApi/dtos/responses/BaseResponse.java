package com.balancee.rewardsManagementApi.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseResponse <T> {
    private int code;
    private boolean status;
    private T data;
}
