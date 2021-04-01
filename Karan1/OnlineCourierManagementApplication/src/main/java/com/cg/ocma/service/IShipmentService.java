package com.cg.ocma.service;

import com.cg.ocma.exception.CourierNotFoundException;

public interface IShipmentService {

	public boolean initiateShipmentTransaction(int courierid) throws CourierNotFoundException;
	public String checkShipmentStatus(int courierid) throws CourierNotFoundException;
	public boolean closeShipmentTransaction(int courierid) throws CourierNotFoundException;
	public boolean rejectShipmentTransaction(int courierid) throws CourierNotFoundException;
	
}
