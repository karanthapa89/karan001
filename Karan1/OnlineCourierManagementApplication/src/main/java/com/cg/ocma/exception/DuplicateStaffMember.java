package com.cg.ocma.exception;

public class DuplicateStaffMember extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateStaffMember(String errorMsg) {
		super(errorMsg);
	}

}