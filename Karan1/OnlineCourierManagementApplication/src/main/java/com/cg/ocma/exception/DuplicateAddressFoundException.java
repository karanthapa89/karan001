package com.cg.ocma.exception;

public class DuplicateAddressFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateAddressFoundException(String errorMsg) {
		super(errorMsg);
	}

}