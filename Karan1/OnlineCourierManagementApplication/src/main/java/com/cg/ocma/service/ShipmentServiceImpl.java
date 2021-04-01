package com.cg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ocma.entities.CourierStatus;
import com.cg.ocma.exception.CourierNotFoundException;
import com.cg.ocma.repository.CourierRepo;

@Service
public class ShipmentServiceImpl implements IShipmentService {
	
	@Autowired
	private CourierRepo courierRepo;
	
	@Autowired
	private EMParser parser;

	public ShipmentServiceImpl() {
		
		/* No implementation */
	}

	public ShipmentServiceImpl(CourierRepo courierRepo) {
		super();
		this.courierRepo = courierRepo;
		this.parser=new EMParser();
	}

	@Override
	public boolean initiateShipmentTransaction(int courierid) throws CourierNotFoundException{
		
		if(courierRepo.existsById(courierid) == false) {
			
			throw new CourierNotFoundException("Courier with id " + courierid + " does not exist");
			
		} else{

			(courierRepo.findById(courierid).orElse(null)).setStatus(CourierStatus.INTRANSIT);
			parser.parse(courierRepo.save(courierRepo.findById(courierid).orElse(null)));
			return true;
			
		}
		
	}

	@Override
	public String checkShipmentStatus(int courierid) throws CourierNotFoundException{

		if(courierRepo.existsById(courierid) == false) {
			
			throw new CourierNotFoundException("Courier with id " + courierid + " doesn't exist!");
		} else {
			return (courierRepo.findById(courierid).orElse(null)).getStatus().toString();
		}
		
	}

	@Override
	public boolean closeShipmentTransaction(int courierid) throws CourierNotFoundException{
		
		if(courierRepo.existsById(courierid) == false) {
			
			throw new CourierNotFoundException("Courier with id " + courierid + " does not exist");
			
		} else{
			

			(courierRepo.findById(courierid).orElse(null)).setStatus(CourierStatus.DELIVERED);
			parser.parse(courierRepo.save(courierRepo.findById(courierid).orElse(null)));
			return true;
			
		}
		
	}

	@Override
	public boolean rejectShipmentTransaction(int courierid) throws CourierNotFoundException{
		if(courierRepo.existsById(courierid) == false) {
			
			throw new CourierNotFoundException("Courier with id " + courierid + " does not exist");
			
		} else{
			

			(courierRepo.findById(courierid).orElse(null)).setStatus(CourierStatus.REJECTED);
			parser.parse(courierRepo.save(courierRepo.findById(courierid).orElse(null)));
			return true;
			
		}
	}

}
