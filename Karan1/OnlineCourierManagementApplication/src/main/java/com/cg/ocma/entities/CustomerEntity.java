package com.cg.ocma.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
	private int customerid;
	
	@Column(name = "aadharno")
	private long aadharno;
	
	@Column(name = "firstname", length = 20)
	private String firstname;
	
	@Column(name = "lastname", length = 20)
	private String lastname;
	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private AddressEntity addr;
	
	@Column(name = "mobileno")
	private long mobileno;
	
	@Embedded
	private BankAccountEntity acct;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List <ComplaintEntity> complaints;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List <CourierEntity> couriers;
	
	public CustomerEntity() {
		
		/*No implementation*/
		
	}

	public CustomerEntity(int customerid, long aadharno, String firstname, String lastname, long mobileno, BankAccountEntity acct) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
		this.acct = acct;
	}

	public CustomerEntity(int customerid, long aadharno, String firstname, String lastname, long mobileno) {
		super();
		this.customerid = customerid;
		this.aadharno = aadharno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileno = mobileno;
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

	public int getCustomerid() {
		return customerid;
	}

	@Override
	public String toString() {
		return "CustomerEntity [customerid=" + customerid + ", aadharno=" + aadharno + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", addr=" + addr + ", mobileno=" + mobileno + ", acct=" + acct
				+ ", complaints=" + complaints + ", couriers=" + couriers + "]";
	}

}