package com.userService.scalableservices.model;

import lombok.Data;

@Data
public class LoanDto {

    private int userId;
    private int loanAmount;
    private String status;
    
}
