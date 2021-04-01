package com.cg.ocma.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.cg.ocma.entities.CustomerEntity;

public class CourierModel {

	private int courierId;
	
	private int consignmentNo;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate initiatedDate;
	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate deliveredDate;
	
	private CustomerEntity customer;
	
	private String status;

	public CourierModel() {
		
	}

	public CourierModel(int courierId, int consignmentNo, LocalDate initiatedDate, LocalDate deliveredDate, String status, CustomerEntity customer) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
		this.status = status;
		this.customer = customer;
	}

	public CourierModel(int courierId, int consignmentNo, LocalDate initiatedDate, LocalDate deliveredDate) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
	}

	public CourierModel(int courierId, int consignmentNo,LocalDate initiatedDate) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
	}
	
	public CourierModel(int courierId, int consignmentNo,LocalDate initiatedDate, LocalDate deliveredDate, String status) {
		super();
		this.courierId = courierId;
		this.consignmentNo = consignmentNo;
		this.initiatedDate = initiatedDate;
		this.deliveredDate = deliveredDate;
		this.status = status;
	}

	public int getCourierId() {
		return courierId;
	}

	public int getConsignmentNo() {
		return consignmentNo;
	}

	public void setConsignmentNo(int consignmentNo) {
		this.consignmentNo = consignmentNo;
	}

	public LocalDate getInitiatedDate() {
		return initiatedDate;
	}

	public void setInitiatedDate(LocalDate initiatedDate) {
		this.initiatedDate = initiatedDate;
	}

	public LocalDate getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDate deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "CourierModel [courierId=" + courierId + ", consignmentNo=" + consignmentNo + ", initiatedDate="
				+ initiatedDate + ", deliveredDate=" + deliveredDate + ", customer=" + customer + "]";
	}
	
	
	
}
