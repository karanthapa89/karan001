package com.cg.ocma.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cg.ocma.entities.BankAccountEntity;

public class CustomerModel {
	
	private int customerid;
	
	@NotNull(message="This field cannot be omitted")
	private long aadharno;
	
	@NotEmpty(message="This field cannot be empty")
	private String firstname;
	
	@NotEmpty(message="This field cannot be empty")
	private String lastname;
	
	private long mobileno;

	private BankAccountEntity acct;

	public CustomerModel() {
		 
	}

	public CustomerModel(int customerid,long aadharno, String firstname, String lastname, long mobileno, BankAccountEntity acct) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.acct = acct;
	}
	
	public CustomerModel(int customerid, long aadharno, String firstname, String lastname, long mobileno) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
	}

	public int getCustomerid() {
		return customerid;
	}

	public long getAadharno() {
		return aadharno;
	}

	public void setAadharno(long aadharno) {
		this.aadharno = aadharno;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public BankAccountEntity getAcct() {
		return acct;
	}

	public void setAcct(BankAccountEntity acct) {
		this.acct = acct;
	}
	
	@Override
	public String toString() {
		return "CustomerModel [customerid=" + customerid + ", aadharno=" + aadharno + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", mobileno=" + mobileno + ", acct=" + acct + "]";
	}
	
}
