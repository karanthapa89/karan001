package com.cg.ocma.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ocma.exception.AddressNotFoundException;
import com.cg.ocma.exception.ComplaintNotFoundException;
import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.exception.DuplicateStaffMember;
import com.cg.ocma.exception.StaffMemberNotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.OfficeStaffMembersModel;
import com.cg.ocma.service.IManagerService;

@RestController
@RequestMapping("/home/manager")
@CrossOrigin
public class ManagerRestController {

	@Autowired
	private IManagerService managerService;
	
	@PostMapping("/{managerid}")
	public ResponseEntity <String> loginAction(@PathVariable("managerid") int managerid) {
		
		return new ResponseEntity <> ("Manager with manager id " + managerid + " has successfully logged in!", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{managerid}/addStaff")
	public ResponseEntity <String> addStaffAction(@RequestBody @Valid OfficeStaffMembersModel staff, BindingResult result) throws DuplicateStaffMember{
		
		if (result.hasErrors()) {
			throw new DuplicateStaffMember(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			int empid = managerService.addStaffMember(staff);
			return new ResponseEntity <> ("You have successfully added staff member with the id " + empid, HttpStatus.CREATED);
			
		}
		
	}
	
	@DeleteMapping("/{managerid}/{empid}")
	public ResponseEntity <String> removeStaffAction(@PathVariable("empid") int empid) throws StaffMemberNotFoundException{
		
		boolean check = managerService.removeStaffMember(empid);
		if(check) {
			
			return new ResponseEntity <> ("You have successfully removed staff member with the id " + empid, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity <> ("Staff Member with the id " + empid + " was not found", HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@GetMapping("/{managerid}/getStaff/{empid}")
	public ResponseEntity <OfficeStaffMembersModel> getStaffAction(@PathVariable("empid") int empid) throws StaffMemberNotFoundException{
		
		return new ResponseEntity <> (managerService.getStaffMember(empid), HttpStatus.FOUND);
		
	}
	
	@GetMapping("/{managerid}/getAllStaff")
	public ResponseEntity <List<OfficeStaffMembersModel>> getAllStaffAction() throws StaffMemberNotFoundException{
		
		return new ResponseEntity <> (managerService.getAllStaffMembers(), HttpStatus.FOUND);
		
	}
	
	@GetMapping("/{managerid}/courierid={courierid}")
	public ResponseEntity <String> checkCourierStatusAction(@PathVariable("courierid") int courierid) throws CourierNotFoundException {
		
		String status = managerService.getCourierStatus(courierid);
		return new ResponseEntity <> ("The status of the courier is: " + status, HttpStatus.OK);
		
	}
	
	@GetMapping("/{managerid}/complaintid={complaintid}")
	public ResponseEntity <ComplaintModel> getComplaintAction(@PathVariable("complaintid") int complaintid) throws DuplicateCustomerFoundException {
		
		return new ResponseEntity <> (managerService.getRegistedComplaint(complaintid), HttpStatus.FOUND);

	}
	
	@GetMapping("/{managerid}/getComplaints")
	public ResponseEntity <List<ComplaintModel>> getAllComplaintAction() throws ComplaintNotFoundException {
		
		return new ResponseEntity <> (managerService.getAllComplaints(), HttpStatus.FOUND);
	}
	
	@GetMapping("/{managerid}/addressid={addressid}")
	public ResponseEntity <AddressModel> getAddressAction(@PathVariable("addressid") int addressid) throws AddressNotFoundException{
		
		return new ResponseEntity <> (managerService.findCustomerAddress(addressid), HttpStatus.FOUND);
		
	}
	
}
