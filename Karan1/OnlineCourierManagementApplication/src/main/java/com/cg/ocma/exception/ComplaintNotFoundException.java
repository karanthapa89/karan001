  
package com.cg.ocma.exception;
public class ComplaintNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ComplaintNotFoundException(String errorMsg) {
		super(errorMsg);
	}

}