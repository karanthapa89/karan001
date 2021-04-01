package com.cg.ocma.exception;
public class DuplicateCustomerFoundException extends Exception {
private static final long serialVersionUID=1L;
	
	public DuplicateCustomerFoundException(String errorMsg) {
		super(errorMsg);
	}
	

}