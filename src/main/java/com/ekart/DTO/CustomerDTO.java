package com.ekart.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerDTO {

	@Email(message = "Please Enter a valid mail")
	@NotBlank
	private String emailId;
	
	@NotBlank(message = "Please Enter the name")
	@Pattern(regexp = "[a-zA-Z]*")
	private String name;
	
	private String password;
	
	private String newPassword;
	
	@Size(max = 10, min = 10 , message = "please Enter a 10 digit number")
	@Pattern(regexp = "[0-9]+")
	private String phoneNumber;
	
	private String address;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}


