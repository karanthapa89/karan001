package com.cg.ocma.controller;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.CustomerNotFoundException;
import com.cg.ocma.exception.DuplicateAddressFoundException;
import com.cg.ocma.exception.DuplicateComplaintFoundException;
import com.cg.ocma.exception.DuplicateCourierFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.exception.DuplicateOfficeOutletFoundException;
import com.cg.ocma.exception.OutletClosedException;
import com.cg.ocma.exception.OutletNotFoundException;
import com.cg.ocma.exception.StaffMemberNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = {OutletClosedException.class})
	public ResponseEntity<Object> handleInvalidExceptions(Exception exp){
		
		return new ResponseEntity<>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {DuplicateComplaintFoundException.class,DuplicateCourierFoundException.class,DuplicateOfficeOutletFoundException.class, DuplicateAddressFoundException.class})
	public ResponseEntity<Object> handleDuplicateExceptions(Exception exp){
		
		return new ResponseEntity<>(exp.getMessage(), HttpStatus.CONFLICT);
	}
		
	@ExceptionHandler(value = {StaffMemberNotFoundException.class,OutletNotFoundException.class,CustomerNotFoundException.class,CourierNotFoundException.class,DuplicateCustomerFoundException.class})
	public ResponseEntity<Object> handleNotFoundExceptions(Exception exp){
		
		return new ResponseEntity<>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleAnyException(Exception exp){
		
		return new ResponseEntity<>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	static String messageFrom(BindingResult result) {		
		
		return result.getAllErrors().stream()
				.map(err -> err.getObjectName() + "-"+err.getDefaultMessage())
				.collect(Collectors.toList()).toString();
	}

}
