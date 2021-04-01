package com.cg.ocma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.ocma.entities.CourierEntity;
import com.cg.ocma.entities.CourierStatus;
import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.exception.DuplicateStaffMember;
import com.cg.ocma.exception.StaffMemberNotFoundException;
import com.cg.ocma.model.OfficeStaffMembersModel;
import com.cg.ocma.repository.ComplaintRepo;
import com.cg.ocma.repository.CourierRepo;
import com.cg.ocma.repository.CustomerRepo;
import com.cg.ocma.repository.ManagerRepo;
import com.cg.ocma.repository.OfficeOutletRepo;

@ExtendWith(MockitoExtension.class)
public class ManagerServiceImplTest {
	
	@Mock
	private ManagerRepo managerRepo;
	
	@Mock
	private CourierRepo courierRepo;
	
	@Mock
	private OfficeOutletRepo officeRepo;
	
	@Mock
	private ComplaintRepo complaintRepo;
	
	@Mock
	private CustomerRepo customerRepo;
	
	@InjectMocks
	private ManagerServiceImpl msImpl;
	
	@Test
	@DisplayName("ManagerServiceImpl:: addStaffMember should throw an exception if the staff already exits")
	void addStaffMemberCheck() throws DuplicateStaffMember{
		
		OfficeStaffMembersModel check = new OfficeStaffMembersModel(1,"Sid","Manager");
		Mockito.when(managerRepo.existsById(check.getEmpid())).thenReturn(true);
		assertThrows(DuplicateStaffMember.class, () -> {
			msImpl.addStaffMember(check);
		});
	}
	
	@Test
	@DisplayName("ManagerServiceImpl:: removeStaffMember should return true if the staff member object is successfully deleted")
	void removeStaffMember() throws StaffMemberNotFoundException{
		int testdata = 6;
		Mockito.when(managerRepo.existsById(testdata)).thenReturn(false);
		assertTrue(msImpl.removeStaffMember(testdata));
	}
	

	@Test
	@DisplayName("ManagerServiceImpl:: removeStaffMember should throws an exception if staff does not exsit")
	void removeStaffMemberCheck() throws StaffMemberNotFoundException{
		
		OfficeStaffMembersModel check = new OfficeStaffMembersModel(1,"Sid","Manager");
		Mockito.when(managerRepo.findById(check.getEmpid())).thenReturn(null);
		assertThrows(StaffMemberNotFoundException.class, () -> {
			msImpl.removeStaffMember(check.getEmpid());
		});
	}
	
	@Test
	@DisplayName("ManagerServiceImpl:: getStaffMember should throws an exception if staff does not exsit")
	void getStaffMemberCheck() throws StaffMemberNotFoundException{
		
		OfficeStaffMembersModel check = new OfficeStaffMembersModel(1,"Sid","Manager");
		Mockito.when(managerRepo.findById(check.getEmpid())).thenReturn(null);
		assertThrows(StaffMemberNotFoundException.class, () -> {
			msImpl.getStaffMember(check.getEmpid());
		});
	}

	@Test
	@DisplayName("ManagerServiceImpl:: getAllStaffMember should throws an exception if office does not exsit")
	void getAllStaffMemberCheck() throws StaffMemberNotFoundException{
	
		assertThrows(StaffMemberNotFoundException.class, () -> {
			msImpl.getAllStaffMembers();
		});
	}
	
	@Test
	@DisplayName("ManagerServiceImpl:: getCourierStatus should return the status of the courier")
	void getCourierStatus() throws CourierNotFoundException{
		
		String expected = "INITIATED";
		int courierid = 6;
		
		CourierEntity testdata = new CourierEntity(6, 5436, LocalDate.parse("2021-01-13"), LocalDate.parse("2021-01-22"), CourierStatus.INITIATED);
		
		Mockito.when(courierRepo.existsById(courierid)).thenReturn(true);
		Mockito.when(courierRepo.findById(courierid)).thenReturn(Optional.of(testdata));
		
		String actual = msImpl.getCourierStatus(courierid);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("CustomerServiceImpl:: checkOnlineTrackingStatusCheck should give an exception when the Courier is not found")
	void getCourierStatusCheck() throws CourierNotFoundException {
		
		//Courier testdata = new Courier(1,5123,LocalDate.parse("2020-11-03"),LocalDate.parse("2021-03-20"),CourierStatus.INITIATED);
		int courierid = 1;
		Mockito.when(courierRepo.existsById(courierid)).thenReturn(false);
		assertThrows(CourierNotFoundException.class, () -> {
			msImpl.getCourierStatus(courierid);
		});
		
	}

	@Test
	@DisplayName("ManagerServiceImpl:: getRegisteredComplaint should throws an exception if complaint does not exsit")
	void getRegistedComplaintCheck() throws DuplicateCustomerFoundException{
		
		//OfficeStaffMembersModel check = new OfficeStaffMembersModel(1,"Sid","Manager");
		int customerid=1;
	//	Mockito.when(managerRepo.existsById(customerid)).thenReturn(false);
		assertThrows(DuplicateCustomerFoundException.class, () -> {
			msImpl.getRegistedComplaint(customerid);
		});
	}
}
