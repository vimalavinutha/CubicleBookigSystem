package com.capgemini.seatbooking.exception;

public class ProfileManagementException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public ProfileManagementException(String message) {
        super(message);
    }
}