package com.capgemini.seatbooking.controller;

import com.capgemini.seatbooking.dto.AdminLoginDto;
import com.capgemini.seatbooking.dto.LoginDto;
import com.capgemini.seatbooking.dto.UserDto;
import com.capgemini.seatbooking.dto.UserProfileDto;
import com.capgemini.seatbooking.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
		userService.registerUser(userDto);
		return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {
		userService.loginUser(loginDto);
		return new ResponseEntity<>("Login sucessful", HttpStatus.OK);
	}

	@PutMapping("/login/update-profile")
	public ResponseEntity<String> updateUserProfile(@RequestBody UserProfileDto userProfileDto) {
		userService.updateUserProfile(userProfileDto);
		return new ResponseEntity<>("password updated sucessfully", HttpStatus.OK);

	}

	@PostMapping("/admin/login")
	public ResponseEntity<String> adminLoginUser(@RequestBody AdminLoginDto AdminLoginDto) {
		userService.adminLoginUser(AdminLoginDto);
		return new ResponseEntity<>("Admin Login sucessful", HttpStatus.OK);
	}

}
