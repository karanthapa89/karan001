package com.cg.ocma.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.cg.ocma.entities.CourierOfficeOutletEntity;

public class OfficeStaffMembersModel {
	
	private int empid;
	
	@NotEmpty(message="Employee name cannot be empty")
	@NotNull(message="Employee name cannot be omitted")
	private String name;
	
	@NotEmpty(message="Employee role cannot be empty")
	@NotNull(message="Employee role cannot be omitted")
	private String role;
	
	private CourierOfficeOutletEntity office;

	public OfficeStaffMembersModel() {
		
		/*No implementation*/
		
	}

	public OfficeStaffMembersModel(int empid, String name, String role, CourierOfficeOutletEntity office) {
		super();
		this.empid = empid;
		this.name = name;
		this.role = role;
		this.office = office;
	}

	public OfficeStaffMembersModel(int empid, String name, String role) {
		super();
		this.empid = empid;
		this.name = name;
		this.role = role;
	}

	public int getEmpid() {
		return empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CourierOfficeOutletEntity getOffice() {
		return office;
	}

	public void setOffice(CourierOfficeOutletEntity office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "OfficeStaffMembersModel [empid=" + empid + ", name=" + name + ", role=" + role + ", office=" + office
				+ "]";
	}
}
