package com.myapi.spring.onlinetutorial.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> 
		handleAllExceptions(Exception ex, WebRequest request){
		
		ExceptionResponse response = 
				new ExceptionResponse(new Date(), 
													  ex.getMessage(),
													  request.getDescription(false)
													  );
		return  new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TopicNotFoundException.class)
	public final ResponseEntity<Object> 
		handleNotFoundException(TopicNotFoundException ex, WebRequest request){
		
		ExceptionResponse response = 
				new ExceptionResponse(new Date(), 
													  ex.getMessage(),
													  request.getDescription(false)
													  );
		return  new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}

}
