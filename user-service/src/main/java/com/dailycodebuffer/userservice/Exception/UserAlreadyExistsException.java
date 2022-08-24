package com.dailycodebuffer.userservice.Exception;

public class UserAlreadyExistsException extends RuntimeException{

	private String msg;
	
	public UserAlreadyExistsException()
	{
		
	}

	public UserAlreadyExistsException(String msg) {
		super();
		this.msg = msg;
	}
	
	
}
