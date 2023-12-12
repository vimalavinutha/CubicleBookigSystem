package com.capgemini.seatbooking.exception;

public class AdminLoginException extends RuntimeException
{
	
	private static final long serialVersionUID = 1L;

	public AdminLoginException(String message) {
        super(message);
    }

}
