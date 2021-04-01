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

import com.cg.ocma.exception.DuplicateAddressFoundException;
import com.cg.ocma.exception.DuplicateOfficeOutletFoundException;
import com.cg.ocma.exception.OutletClosedException;
import com.cg.ocma.exception.OutletNotFoundException;
import com.cg.ocma.model.AddressModel;
import com.cg.ocma.model.CourierOfficeOutletModel;
import com.cg.ocma.service.IOfficeOutletService;

@RestController
@RequestMapping("/home/{managerid}/office")
@CrossOrigin
public class OfficeOutletRestController {
	
	private static final String CHECK = "The courier office outlet with id ";
	
	@Autowired
	private IOfficeOutletService officeService;
	
	@PostMapping("/addOffice")
	public ResponseEntity <String> addOfficeAction(@RequestBody @Valid CourierOfficeOutletModel office, BindingResult result) throws DuplicateOfficeOutletFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateOfficeOutletFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			int officeid = officeService.addNewOffice(office);
			return new ResponseEntity <> ("You have successfully added a new office with the id " + officeid, HttpStatus.CREATED);

			
		}
		
	}
	
	@PostMapping("/addOffice/registerAddress")
	public ResponseEntity <String> registerAddressAction(@RequestBody @Valid AddressModel address, BindingResult result) throws DuplicateAddressFoundException{
		
		if (result.hasErrors()) {
			throw new DuplicateAddressFoundException(GlobalExceptionHandler.messageFrom(result));
		} else {
			
			int addressid = officeService.registerOfficeAddress(address);
			return new ResponseEntity <> ("You have successfully registered the office address with the id " + addressid, HttpStatus.CREATED);
			
		}
		
	}
	
	@DeleteMapping("deleteOffice/{officeid}")
	public ResponseEntity <String> removeOfficeAction(@PathVariable("officeid") int officeid) throws OutletNotFoundException {
		
		boolean check = officeService.removeNewOffice(officeid);
		if(check) {
			
			return new ResponseEntity <> ("You have successfully removed office with the id " + officeid, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity <> ("Office with the id " + officeid + " was not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getOffice/officeid={officeid}")
	public ResponseEntity <CourierOfficeOutletModel> getOfficeInfo(@PathVariable("officeid") int officeid) throws OutletNotFoundException{
		
		return new ResponseEntity <> (officeService.getOfficeInfo(officeid), HttpStatus.FOUND);
		
	}
	
	@GetMapping("/getAllOffice")
	public ResponseEntity <List<CourierOfficeOutletModel>> getAllOfficesData() throws OutletNotFoundException{
		
		return new ResponseEntity <> (officeService.getAllOfficesData(), HttpStatus.FOUND);
		
	}
	
	@GetMapping("checkOfficeOpen/{officeid}")
	public ResponseEntity <String> isOfficeOpen(@PathVariable("officeid") int officeid) throws OutletClosedException {
		
		boolean status = officeService.isOfficeOpen(officeid);
		if(status) {
			
			return new ResponseEntity <> (CHECK + officeid + " is open: ", HttpStatus.OK);
		} else {
			
			return new ResponseEntity <> (CHECK + officeid + " is closed: ", HttpStatus.OK);
		}
	}
	
	@GetMapping("/checkOfficeClosed/{officeid}")
	public ResponseEntity <String> isOfficeClosed(@PathVariable("officeid") int officeid) throws OutletClosedException {
		
		boolean status = officeService.isOfficeClosed(officeid);
		if(status) {
			
			return new ResponseEntity <> (CHECK + officeid + " is closed: ", HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity <> (CHECK + officeid + " is opened: ", HttpStatus.OK);
	
		}
	}

}
