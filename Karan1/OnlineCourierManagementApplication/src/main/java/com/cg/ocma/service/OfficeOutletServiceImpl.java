package com.cg.ocma.service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ocma.exception.DuplicateAddressFoundException;
import com.cg.ocma.exception.DuplicateOfficeOutletFoundException;
import com.cg.ocma.exception.OutletClosedException;
import com.cg.ocma.exception.OutletNotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.CourierOfficeOutletModel;
import com.cg.ocma.repository.AddressRepo;
import com.cg.ocma.repository.OfficeOutletRepo;

@Service
public class OfficeOutletServiceImpl implements IOfficeOutletService {
	
	@Autowired
	private OfficeOutletRepo officeRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private EMParser parser;

	public OfficeOutletServiceImpl() {
		
		/* No implementation */
	}

	public OfficeOutletServiceImpl(OfficeOutletRepo officeRepo) {
		super();
		this.officeRepo = officeRepo;
		this.parser=new EMParser();
	}

	@Transactional
	@Override
	public int addNewOffice(CourierOfficeOutletModel officeoutlet) throws DuplicateOfficeOutletFoundException{
		
		if(officeoutlet != null) {
			if(officeRepo.existsById(officeoutlet.getOfficeid())) {
				
				throw new DuplicateOfficeOutletFoundException("Office Outlet with id " + officeoutlet.getOfficeid() + " already exists!");
			} else {
				
				parser.parse(officeRepo.save(parser.parse(officeoutlet)));
			}
		} 
		return officeoutlet.getOfficeid();
		
	}
	
	@Transactional
	@Override
	public int registerOfficeAddress(AddressModel address) throws DuplicateAddressFoundException{
		if(address != null) {
			if(addressRepo.existsById(address.getAddressid())) {
				
				throw new DuplicateAddressFoundException("Address with id " + address.getAddressid() + " already exists!");
			} else {
				
				parser.parseOffice(addressRepo.save(parser.parseOffice(address)));
			}
		}
		return address.getAddressid();
	}

	@Transactional
	@Override
	public boolean removeNewOffice(int officeid) throws OutletNotFoundException {
		
		boolean flag = false;
		if(officeRepo.existsById(officeid) == false) {
			throw new OutletNotFoundException("Office Outlet with id " + officeid + " doesn't exist!");	
		} else {
			officeRepo.deleteById(officeid);
			flag = true;
		}
		return flag;
		
	}

	@Override
	public CourierOfficeOutletModel getOfficeInfo(int officeid) throws OutletNotFoundException {
		
		if(officeRepo.existsById(officeid) == false) {
			throw new OutletNotFoundException("Office with id " + officeid + " doesn't exist!");
		} else {
			return parser.parse(officeRepo.findById(officeid).orElse(null));
		}
	}

	@Override
	public List<CourierOfficeOutletModel> getAllOfficesData() throws OutletNotFoundException{
		
		if(officeRepo.count() == 0) {
			
			throw new OutletNotFoundException("No Offices exist!");
			
		} else {
			
			return officeRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
			
		}
	}

	@Override
	public boolean isOfficeOpen(int officeid) throws OutletClosedException {
		
		if(officeRepo.existsById(officeid) == false) {
			
			throw new OutletClosedException("Office with id " + officeid + " doesn't exist!");
		} else {
			
			CourierOfficeOutletModel office = parser.parse(officeRepo.findById(officeid).get());
			LocalTime open = LocalTime.parse(office.getOpeningTime());
			LocalTime close = LocalTime.parse(office.getClosingTime());
			if((open.equals(LocalTime.now()) || open.isBefore(LocalTime.now())) && close.isAfter(LocalTime.now())) {
				
				return true;
				
			} else {
				
				return false;
				
			}
		}
	}

	@Override
	public boolean isOfficeClosed(int officeid) throws OutletClosedException {
		if(officeRepo.findById(officeid) == null) {
			throw new OutletClosedException("Office with id " + officeid + " doesn't exist!");
		} else {
			
			CourierOfficeOutletModel office = parser.parse(officeRepo.findById(officeid).get());
			LocalTime open = LocalTime.parse(office.getOpeningTime());
			LocalTime close = LocalTime.parse(office.getClosingTime());
			if((close.equals(LocalTime.now()) || close.isBefore(LocalTime.now())) && open.isAfter(LocalTime.now())) {
				
				return true;
			} else {
				
				return false;
				
			}
		}
	}

	

}
