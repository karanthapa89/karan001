package com.cg.ocma.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ocma.exception.AddressNotFoundException;
import com.cg.ocma.exception.ComplaintNotFoundException;
import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.exception.DuplicateCustomerFoundException;
import com.cg.ocma.exception.DuplicateStaffMember;
import com.cg.ocma.exception.StaffMemberNotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.ComplaintModel;
import com.cg.ocma.model.OfficeStaffMembersModel;
import com.cg.ocma.repository.AddressRepo;
import com.cg.ocma.repository.ComplaintRepo;
import com.cg.ocma.repository.CourierRepo;
import com.cg.ocma.repository.ManagerRepo;
import com.cg.ocma.repository.OfficeOutletRepo;

@Service
public class ManagerServiceImpl implements IManagerService {
	
	@Autowired
	private ManagerRepo managerRepo;
	
	@Autowired
	private CourierRepo courierRepo;
	
	@Autowired
	private OfficeOutletRepo officeRepo;
	
	@Autowired
	private ComplaintRepo complaintRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private EMParser parser;
	

	public ManagerServiceImpl() {
		/* No implementation */
	}

	public ManagerServiceImpl(ManagerRepo managerRepo, CourierRepo courierRepo, OfficeOutletRepo officeRepo,
			ComplaintRepo complaintRepo) {
		super();
		this.managerRepo = managerRepo;
		this.courierRepo = courierRepo;
		this.officeRepo = officeRepo;
		this.complaintRepo = complaintRepo;
		this.parser=new EMParser();
	}

	@Transactional
	@Override
	public int addStaffMember(OfficeStaffMembersModel staffmember) throws DuplicateStaffMember {
		if(staffmember != null) {
			if(managerRepo.existsById(staffmember.getEmpid())) {
				throw new DuplicateStaffMember("Staff with id " + staffmember.getEmpid() + " already exists!");
			} else {
				parser.parse(managerRepo.save(parser.parse(staffmember)));
			}
		} 
		return staffmember.getEmpid();
	}

	@Transactional
	@Override
	public boolean removeStaffMember(int empid) throws StaffMemberNotFoundException{
		boolean flag = false;
		if(managerRepo.findById(empid) == null) {
			throw new StaffMemberNotFoundException("Staff with id " + empid + " doesn't exist!");	
		} else {
			managerRepo.deleteById(empid);
			if(managerRepo.existsById(empid) == false) {
				
				flag = true;
				
			}
		}
		return flag;
	}

	@Override
	public OfficeStaffMembersModel getStaffMember(int empid) throws StaffMemberNotFoundException {
		if(managerRepo.findById(empid) == null) {
			throw new StaffMemberNotFoundException("Staff with id " + empid + " doesn't exist!");
		} else {
			return parser.parse(managerRepo.findById(empid).get());
		}
	}

	@Override
	public List<OfficeStaffMembersModel> getAllStaffMembers() throws StaffMemberNotFoundException{
	
		if(officeRepo.count() == 0) {
			
			throw new StaffMemberNotFoundException("No office staff members found!");
		} else {
			
			return managerRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
		}
	}

	@Override
	public String getCourierStatus(int courierid) throws CourierNotFoundException {
		if(courierRepo.existsById(courierid) == false) {
			
			throw new CourierNotFoundException("Courier with id " + courierid + " doesn't exist!");
		} else {
			
			return (courierRepo.findById(courierid).orElse(null)).getStatus().toString();
		}
	}

	@Override
	public ComplaintModel getRegistedComplaint(int complaintid) throws DuplicateCustomerFoundException {
		if(complaintRepo.existsById(complaintid) == false) {
			
			throw new DuplicateCustomerFoundException("Complaint with id " + complaintid + " doesn't exist!");
			
		} else {
			return parser.parse(complaintRepo.findById(complaintid).orElse(null));
		}
	}

	@Override
	public List<ComplaintModel> getAllComplaints() throws ComplaintNotFoundException{
		
		if(complaintRepo.count() == 0) {
			
			throw new ComplaintNotFoundException("No complaints found!");
		} else {
			
			return complaintRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
		}
	}

	@Override
	public AddressModel findCustomerAddress(int addressid) throws AddressNotFoundException {
		
		if(addressRepo.existsById(addressid) == false) {
			
			throw new AddressNotFoundException("The address with id: " + addressid + " doesn't exist!");
			
		}else {
			
			return parser.parse(addressRepo.findById(addressid).orElse(null));
			
		}
		
	}

}
