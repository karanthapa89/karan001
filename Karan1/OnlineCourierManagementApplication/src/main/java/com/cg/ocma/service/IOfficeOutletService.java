package com.cg.ocma.service;

import java.util.List;

import com.cg.ocma.exception.DuplicateAddressFoundException;
import com.cg.ocma.exception.DuplicateOfficeOutletFoundException;
import com.cg.ocma.exception.OutletClosedException;
import com.cg.ocma.exception.OutletNotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.CourierOfficeOutletModel;

public interface IOfficeOutletService {
	
	public int addNewOffice(CourierOfficeOutletModel officeoutlet) throws DuplicateOfficeOutletFoundException;
	public int registerOfficeAddress(AddressModel address) throws DuplicateAddressFoundException;
	public boolean removeNewOffice(int officeid) throws OutletNotFoundException;
	public CourierOfficeOutletModel getOfficeInfo(int officeid) throws OutletNotFoundException;
	public List<CourierOfficeOutletModel> getAllOfficesData() throws OutletNotFoundException;
	public boolean isOfficeOpen(int officeid) throws OutletClosedException;
	public boolean isOfficeClosed(int officeid)throws OutletClosedException;
	
}