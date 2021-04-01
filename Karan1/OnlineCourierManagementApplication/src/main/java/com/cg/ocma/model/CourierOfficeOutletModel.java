package com.cg.ocma.model;

public class CourierOfficeOutletModel {
	
	private int officeid;
	
	private String openingTime;
	
	private String closingTime;

	public CourierOfficeOutletModel() {
		
		/*No implementation*/
		 
	}

	public CourierOfficeOutletModel(int officeid, String openingTime, String closingTime) {
		super();
		this.officeid = officeid;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
	}

	public int getOfficeid() {
		return officeid;
	}

	public void setOfficeid(int officeid) {
		this.officeid = officeid;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}

	@Override
	public String toString() {
		return "CourierOfficeOutletModel [officeid=" + officeid + ", openingTime=" + openingTime + ", closingTime="
				+ closingTime + "]";
	}

}
