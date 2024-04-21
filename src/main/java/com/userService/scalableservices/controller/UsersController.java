package com.userService.scalableservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userService.scalableservices.service.UserService;
import com.userService.scalableservices.model.LoanDto;
import com.userService.scalableservices.model.UserDto;

@RestController
public class UsersController {
	@Autowired
	private UserService userService;

    @PostMapping("/user/add")
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.insertUser(userDto);
    }

    @PostMapping("/user/apply/loan")
    public LoanDto applyLoan(@RequestBody LoanDto loanDto) {
        return userService.applyLoan(loanDto);
    }

    
}
