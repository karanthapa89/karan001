package com.cg.ocma.exception;

public class DuplicateComplaintFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateComplaintFoundException(String errorMsg) {
		super(errorMsg);
	}

}