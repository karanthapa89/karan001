package com.cg.ocma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courierofficeoutlet")
public class CourierOfficeOutletEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "officeid")
	private int officeid;
	
	@OneToOne(mappedBy = "office", cascade = CascadeType.ALL)
	private AddressEntity addr;
	
	@Column(name = "openingtime")	
	private String openingTime;
	
	@Column(name = "closingtime")
	private String closingTime;

	@OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
	private List <OfficeStaffMembersEntity> officeStaff;
	
	public CourierOfficeOutletEntity() {
		
		/*No implementation*/
			
	}

	public CourierOfficeOutletEntity(int officeid, String openingTime, String closingTime) {
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
		return "CourierOfficeOutletEntity [officeid=" + officeid + ", addr=" + addr + ", openingTime=" + openingTime
				+ ", closingTime=" + closingTime + ", officeStaff=" + officeStaff + "]";
	}

	
}