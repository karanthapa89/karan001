package com.cg.ocma.service;

import org.springframework.stereotype.Service;

import com.cg.ocma.entities.AddressEntity;
import com.cg.ocma.entities.ComplaintEntity;
import com.cg.ocma.entities.CourierEntity;
import com.cg.ocma.entities.CourierOfficeOutletEntity;
import com.cg.ocma.entities.CourierStatus;
import com.cg.ocma.entities.CustomerEntity;
import com.cg.ocma.entities.OfficeStaffMembersEntity;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.CourierModel;
import com.cg.ocma.model.CourierOfficeOutletModel;
import com.cg.ocma.model.CustomerModel;
import com.cg.ocma.model.OfficeStaffMembersModel;

@Service
public class EMParser {
	
	public CustomerModel parse(CustomerEntity customer) {
		
		return customer==null?null:
			
			new CustomerModel(customer.getCustomerid(),
					customer.getAadharno(),
					customer.getFirstname(),
					customer.getLastname(),
					customer.getMobileno(),
					customer.getAcct());
		
	}
	
	public CustomerEntity parse(CustomerModel customer) {
		
		return customer==null?null:
			
			new CustomerEntity(customer.getCustomerid(),
					customer.getAadharno(),
					customer.getFirstname(),
					customer.getLastname(),
					customer.getMobileno(),
					customer.getAcct());
		
	}
	
	public AddressEntity parse(AddressModel address) {
		
		return address==null?null:
			
			new AddressEntity(address.getAddressid(),
					address.getHouseNo(),
					address.getStreet(),
					address.getCity(),
					address.getState(),
					address.getCountry(),
					address.getZip(),
					address.getCustomer());
		
	}
	
	public AddressModel parse(AddressEntity address) {
		
		return address==null?null:
			
			new AddressModel(address.getAddressid(),
					address.getHouseNo(),
					address.getStreet(),
					address.getCity(),
					address.getState(),
					address.getCountry(),
					address.getZip(),
					address.getCustomer());
		
	}
	
	public AddressEntity parseOffice(AddressModel address) {
		
		return address==null?null:
			
			new AddressEntity(address.getAddressid(),
					address.getHouseNo(),
					address.getStreet(),
					address.getCity(),
					address.getState(),
					address.getCountry(),
					address.getZip(),
					address.getOffice());
		
	}
	
	public AddressModel parseOffice(AddressEntity address) {
		
		return address==null?null:
			
			new AddressModel(address.getAddressid(),
					address.getHouseNo(),
					address.getStreet(),
					address.getCity(),
					address.getState(),
					address.getCountry(),
					address.getZip(),
					address.getOffice());
	}
	
	public CourierModel parse(CourierEntity courier) {
		
		return courier==null?null:
			
			new CourierModel(courier.getCourierId(),
					courier.getConsignmentNo(),
					courier.getInitiatedDate(),
					courier.getDeliveredDate(),
					courier.getStatus().toString(),
					courier.getCustomer());
		
	}
	
	public CourierEntity parse(CourierModel courier) {
		
		return courier==null?null:
			
			new CourierEntity(courier.getCourierId(),
					courier.getConsignmentNo(),
					courier.getInitiatedDate(),
					courier.getDeliveredDate(),
					courier.getCustomer(),
					CourierStatus.valueOf(courier.getStatus()));
		
	}
	
	public ComplaintModel parse(ComplaintEntity complaint) {
		
		return complaint==null?null:
			
			new ComplaintModel(complaint.getComplaintId(),
					complaint.getConsignmentNo(),
					complaint.getShortDescription(),
					complaint.getDetailDescription(),
					complaint.getCustomer());
		
	}
	
	public ComplaintEntity parse(ComplaintModel complaint) {
		
		return complaint==null?null:
			
			new ComplaintEntity(complaint.getComplaintId(),
					complaint.getConsignmentNo(),
					complaint.getShortDescription(),
					complaint.getDetailDescription(),
					complaint.getCustomer());
		
	}
	
	public CourierOfficeOutletModel parse(CourierOfficeOutletEntity office) {
		
		return office==null?null:
			
			new CourierOfficeOutletModel(office.getOfficeid(),
					office.getOpeningTime(),
					office.getClosingTime());
	}
	
	public CourierOfficeOutletEntity parse(CourierOfficeOutletModel office) {
		
		return office==null?null:
			
			new CourierOfficeOutletEntity(office.getOfficeid(),
					office.getOpeningTime(),
					office.getClosingTime());
	}
	
	public OfficeStaffMembersModel parse(OfficeStaffMembersEntity staff) {
		
		return staff==null?null:
			
			new OfficeStaffMembersModel(staff.getEmpid(),
					staff.getName(),
					staff.getRole(),
					staff.getOffice());
	}
	
	public OfficeStaffMembersEntity parse(OfficeStaffMembersModel staff) {
		
		return staff==null?null:
			
			new OfficeStaffMembersEntity(staff.getEmpid(),
					staff.getName(),
					staff.getRole(),
					staff.getOffice());
	}
	
}
