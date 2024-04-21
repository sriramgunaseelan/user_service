package com.userService.scalableservices.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class Users {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="age")
	private int age;
	
	@Column(name="occupation")
	private String occupation;
	
	@Column(name="annual_income")
	private double annualIncome;
	
	@Override
	  public String toString() {
	    return "{" + "id=" + this.id + ", first_name='" + this.firstName + "', last_name='" + this.lastName + "'}";
	  }
	
}
