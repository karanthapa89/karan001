package com.cg.ocma.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cg.ocma.entities.CourierOfficeOutletEntity;
import com.cg.ocma.entities.CustomerEntity;

public class AddressModel {
	
	private int addressid;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String houseNo;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String street;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String city;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String state;
	
	@NotEmpty(message="This field cannot be empty")
	@NotNull(message="This field cannot be omitted")
	private String country;
	

	private int zip;

	private CustomerEntity customer;
	
	private CourierOfficeOutletEntity office;
	
	public AddressModel() {
		
		/*No implementation*/
		
	}
	
	public AddressModel(int addressid, String houseNo, String street, String city, String state, String country, int zip, CourierOfficeOutletEntity office) {
		super();
		this.addressid = addressid;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.office = office;
	}

	public AddressModel(int addressid, String houseNo, String street, String city, String state, String country, int zip, CustomerEntity customer) {
		super();
		this.addressid = addressid;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.customer = customer;
	}

	public AddressModel(int addressid, String houseNo, String street, String city, String state, String country, int zip) {
		super();
		this.addressid = addressid;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public CourierOfficeOutletEntity getOffice() {
		return office;
	}

	public void setOffice(CourierOfficeOutletEntity office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "AddressModel [addressid=" + addressid + ", houseNo=" + houseNo + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zip=" + zip + ", customer=" + customer + ", office="
				+ office + "]";
	}
}
