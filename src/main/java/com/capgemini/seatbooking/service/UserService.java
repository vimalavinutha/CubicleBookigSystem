package com.capgemini.seatbooking.service;
 
import java.util.Base64;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.seatbooking.dto.AdminLoginDto;
import com.capgemini.seatbooking.dto.LoginDto;
import com.capgemini.seatbooking.dto.UserDto;
import com.capgemini.seatbooking.dto.UserProfileDto;
import com.capgemini.seatbooking.entity.User;
import com.capgemini.seatbooking.exception.AdminLoginException;
import com.capgemini.seatbooking.exception.LoginException;
import com.capgemini.seatbooking.exception.ProfileManagementException;
import com.capgemini.seatbooking.exception.RegistrationException;
import com.capgemini.seatbooking.repository.UserRepository;
import com.capgemini.seatbooking.util.UserType;
 
@Service
public class UserService {
 
@Autowired
private UserRepository userRepository;
 
public User registerUser(UserDto userDto) {
     validateUserDto(userDto);
     // Check if the email is already registered
     if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
         throw new RegistrationException("Email already registered");
     }
 
     // Create a new user
     User user = new User();
     user.setEmail(userDto.getEmail());
     user.setUsername(userDto.getUsername());
     String originalInput=userDto.getPassword();
     String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
     user.setPassword(encodedString);
     //user.setUserType(UserType.USER); // Assuming a default user type
     user.setUserType(UserType.ADMIN); 
 
     // Save the user to the database
     return userRepository.save(user);
}
private void validateUserDto(UserDto userDto) {
     if (userDto.getEmail() == null || userDto.getEmail().isEmpty() ||
         userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
         throw new RegistrationException("Email and password cannot be empty.");
     }
}

public void loginUser(LoginDto loginDto) {
     validateLoginDto(loginDto);
 
     // Implement user authentication logic
     String originalInput=loginDto.getPassword();
     String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
     @SuppressWarnings("unused")  
	User user = userRepository.findByEmailAndPassword(loginDto.getEmail(), encodedString)
             .orElseThrow(() -> new LoginException("Invalid credentials"));
}
 

private void validateLoginDto(LoginDto loginDto) {
     if (loginDto.getEmail() == null || loginDto.getEmail().isEmpty() ||
         loginDto.getPassword() == null || loginDto.getPassword().isEmpty()) {
         throw new LoginException("Email and password cannot be empty.");
     }
}
     

public void adminLoginUser(AdminLoginDto adminLoginDto) {
	 validateAdminLoginDto(adminLoginDto);

    // Implement user authentication logic
    String originalInput=adminLoginDto.getPassword();
    String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
    @SuppressWarnings("unused")  
	User user = userRepository.findByEmailAndPassword(adminLoginDto.getEmail(), encodedString)
            .orElseThrow(() -> new AdminLoginException(""));
}


private void validateAdminLoginDto(AdminLoginDto adminLoginDto) {
    if (adminLoginDto.getEmail() == null || adminLoginDto.getEmail().isEmpty() ||
        adminLoginDto.getPassword() == null || adminLoginDto.getPassword().isEmpty()) {
        throw new AdminLoginException("");
    }

    // Add more validation rules as needed
}
     
     public void updateUserProfile(UserProfileDto userProfileDto)
     { 
    	 validateUserProfileDto(userProfileDto);
    	 
    	 String originalInput=userProfileDto.getNewPassword();
         String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
    	 User user = userRepository.findByEmail(userProfileDto.getEmail())               
    			 .orElseThrow(() -> new ProfileManagementException(""));         // Update user profile details       
    	           user.setPassword(encodedString);         
    	           userRepository.save(user);
    	 
     }
    	 
     
     private void validateUserProfileDto(UserProfileDto userProfileDto) {
         if (userProfileDto.getEmail() == null || userProfileDto.getEmail().isEmpty() ||
        		 userProfileDto.getNewPassword() == null || userProfileDto.getNewPassword().isEmpty()) {
             throw new ProfileManagementException("");
         }
         
         
         
 
     // Add more validation rules as needed
}
 
}
 
