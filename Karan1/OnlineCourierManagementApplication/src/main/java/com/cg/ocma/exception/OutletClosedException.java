package com.cg.ocma.exception;

public class OutletClosedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OutletClosedException(String errorMsg) {
		super(errorMsg);
		
	}

}