package com.userService.scalableservices.model;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private int age;
    private double annualIncome;
    private String firstName;
    private String lastName;
    private String gender;
    private String occupation;
    private String status;
}
