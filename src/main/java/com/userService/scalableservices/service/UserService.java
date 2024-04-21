package com.userService.scalableservices.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userService.scalableservices.model.LoanDto;
import com.userService.scalableservices.model.UserDto;
import com.userService.scalableservices.model.Users;
import com.userService.scalableservices.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public UserDto insertUser(UserDto userDto) {
		Users user = new Users();
		Random rand = new Random();
		int id = rand.nextInt(100);
		user.setId(id);
		user.setAnnualIncome(userDto.getAnnualIncome());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setOccupation(userDto.getOccupation());
		user.setGender(userDto.getGender());
		user.setAge(userDto.getAge());
		userRepo.save(user);
		userDto.setStatus("User inserted successfully!");
		userDto.setId(id);
		return userDto;
	}

	public LoanDto applyLoan(LoanDto loanDto) {
		Users user = userRepo.findByUserId(loanDto.getUserId());
		if (user == null) {
			throw new RuntimeException("Invalid user id passed");
		}
		final String uri = "http://localhost:8078/loan/request?userId="
		 + loanDto.getUserId() + "&loanAmount=" + loanDto.getLoanAmount() + "&annualIncome=" + (int) user.getAnnualIncome();
		RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
		loanDto.setStatus(result);
		return loanDto;
	}

}
