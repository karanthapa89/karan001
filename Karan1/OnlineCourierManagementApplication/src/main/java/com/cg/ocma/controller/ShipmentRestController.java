package com.cg.ocma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.service.IShipmentService;

@RestController
@RequestMapping("/home/{managerid}/shipment")
@CrossOrigin
public class ShipmentRestController {
	
	private static final String CHECK = "The courier with id ";
	
	@Autowired
	private IShipmentService shipmentService;
	
	@PatchMapping("/{courierid}/initiate")
	public ResponseEntity <String> initiateShipmentAction(@PathVariable("courierid") int courierid) throws CourierNotFoundException {
		
		boolean flag = shipmentService.initiateShipmentTransaction(courierid);
		if(flag) {
			
			return new ResponseEntity <> ("You have successfully initiated the shipment process for the courier with id " + courierid, HttpStatus.OK);

		} else {
			
			return new ResponseEntity <> (CHECK + courierid + " not found", HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@GetMapping("/{courierid}/checkStatus")
	public ResponseEntity <String> checkShipmentStatusAction(@PathVariable("courierid") int courierid) throws CourierNotFoundException {
		
		String status = shipmentService.checkShipmentStatus(courierid);
		return new ResponseEntity <> ("The status of the courier with courier id " + courierid + " is: " + status, HttpStatus.OK);
		
	}
	
	@PatchMapping("/{courierid}/close")
	public ResponseEntity <String> closeShipmentAction(@PathVariable("courierid") int courierid) throws CourierNotFoundException {
		
		boolean flag = shipmentService.closeShipmentTransaction(courierid);
		if(flag) {
			
			return new ResponseEntity <> ("You have successfully closed the shipment process for the courier with id " + courierid, HttpStatus.OK);
		
		} else {
			
			return new ResponseEntity <> (CHECK + courierid + " not found", HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@PatchMapping("/{courierid}/reject")
	public ResponseEntity <String> rejectShipmentAction(@PathVariable("courierid") int courierid) throws CourierNotFoundException {
		
		boolean flag = shipmentService.rejectShipmentTransaction(courierid);
		if(flag) {
			
			return new ResponseEntity <> ("You have successfully rejected the shipment process for the courier with id " + courierid, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity <> (CHECK + courierid + " not found", HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	
}
