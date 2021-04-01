package com.cg.ocma.exception;

public class DuplicateCourierFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateCourierFoundException(String errorMsg) {
		super(errorMsg);
	}

}