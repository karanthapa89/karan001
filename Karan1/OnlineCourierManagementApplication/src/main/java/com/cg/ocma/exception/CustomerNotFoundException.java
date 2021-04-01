package com.cg.ocma.exception;

public class CustomerNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public CustomerNotFoundException(String errorMsg) {
		super(errorMsg);
	}

}