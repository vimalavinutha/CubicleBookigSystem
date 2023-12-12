package com.capgemini.seatbooking.dto;

public class UserProfileDto {
	private String email;
	private String newPassword;
	
	public UserProfileDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfileDto(String email, String newPassword) {
		super();
		this.email = email;
		this.newPassword = newPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "UserProfileDto [email=" + email + ", newPassword=" + newPassword + "]";
	}
	
	

}
