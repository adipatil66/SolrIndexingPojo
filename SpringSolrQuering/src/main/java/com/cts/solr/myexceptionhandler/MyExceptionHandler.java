package com.cts.solr.myexceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cts.solr.customexception.PathVariableMissingException;
import com.cts.solr.customexception.WrongInputFieldsException;

import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<String> DisplayError(Exception ex){
		return new ResponseEntity<String>("Input field mis match", HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(PathVariableMissingException.class)
	public final ResponseEntity<String> DisplayError(PathVariableMissingException ex){
		return new ResponseEntity<String>(ex.toString(), HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(WrongInputFieldsException.class)
	public final ResponseEntity<String> DisplayRuntimeException(WrongInputFieldsException e){
		return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
		
	}
}
