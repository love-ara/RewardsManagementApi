package com.balancee.rewardsManagementApi.handlers;

import com.balancee.rewardsManagementApi.exceptions.CustomerNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(CustomerNotFoundException exception){
        return ResponseEntity.status(BAD_REQUEST)
                .body(Map.of(
                        "error", exception.getMessage(),
                        "success", false
                ));
    }
}
