
package com.capgemini.seatbooking.handler;
 
import com.capgemini.seatbooking.exception.AdminLoginException;
import com.capgemini.seatbooking.exception.LoginException;
import com.capgemini.seatbooking.exception.ProfileManagementException;
import com.capgemini.seatbooking.exception.RegistrationException;
 
import java.time.LocalDateTime;
 
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
 
@ControllerAdvice

public class GlobalExceptionHandler {
	ApiError error = new ApiError();
 
    @ExceptionHandler(RegistrationException.class)

    public ResponseEntity<Object> handleRegistrationException(RegistrationException ex) {


    	error.setStatus(HttpStatus.BAD_REQUEST);

    	error.setMessage("Invalid Input");

    	error.setTimestamp(LocalDateTime.now());

    	return new ResponseEntity<>(error, HttpStatus.valueOf(400));

    }

    @ExceptionHandler(LoginException.class)

    public ResponseEntity<Object> handleLoginException(LoginException ex){


    	error.setStatus(HttpStatus.UNAUTHORIZED);

    	error.setMessage("Invalid credentials");

    	error.setTimestamp(LocalDateTime.now());

    	return new ResponseEntity<>(error, HttpStatus.valueOf(401));

    }
    
    @ExceptionHandler(ProfileManagementException.class)

    public ResponseEntity<Object> handleProfileManagementException(ProfileManagementException ex){


    	error.setStatus(HttpStatus.BAD_REQUEST);

       error.setTimestamp(LocalDateTime.now());
       
       error.setMessage("Invalid password");

    	return new ResponseEntity<>(error, HttpStatus.valueOf(400));

    }
    
    @ExceptionHandler(AdminLoginException.class)
    public ResponseEntity<Object> handleAdminLoginException(AdminLoginException ex){
 
    	error.setStatus(HttpStatus.UNAUTHORIZED);
    	error.setMessage("Invalid admin credentials");
    	error.setTimestamp(LocalDateTime.now());
    	return new ResponseEntity<>(error, HttpStatus.valueOf(401));
    }
 
    // Add more exception handlers for other exceptions if needed

}


