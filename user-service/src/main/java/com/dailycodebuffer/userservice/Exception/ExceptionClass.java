package com.dailycodebuffer.userservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionClass extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(value=NoSuchCustmomerExistsException.class)
	public ResponseEntity<Object> UserNotFoundException(){
		return new ResponseEntity<Object>("User is not there, try with other user", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=UserAlreadyExistsException.class)
	public ResponseEntity<Object> UserAlreadyExistsExcepion(){
		return new ResponseEntity<Object>("User Already exists", HttpStatus.CONFLICT);
	}
}
