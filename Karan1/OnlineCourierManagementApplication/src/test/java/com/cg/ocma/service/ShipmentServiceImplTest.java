package com.cg.ocma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.cg.ocma.repository.CourierRepo;

@ExtendWith(MockitoExtension.class)
public class ShipmentServiceImplTest {
	
	@Mock
	private CourierRepo courierRepo;
	
	@InjectMocks
	private ShipmentServiceImpl spImpl;
	
	@Test
	@DisplayName("ShipmentServiceImpl:: initiateShipmentTransaction should return true if courier object is successfully created and shipment is initiated")
	void initiateShipmentTransaction() throws CourierNotFoundException {
		boolean expected = true;
		CourierEntity testdata = new CourierEntity(1,5000,LocalDate.parse("2020-11-03"),LocalDate.parse("2021-03-20"));
		Mockito.when(courierRepo.existsById(testdata.getCourierId())).thenReturn(true);
		Mockito.when(courierRepo.findById(testdata.getCourierId())).thenReturn(Optional.of(testdata));
		boolean actual = spImpl.initiateShipmentTransaction(testdata.getCourierId());
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("ShipmentServiceImpl:: checkShipmentStatus should return the status of the courier")
	void checkShipmentStatus() throws CourierNotFoundException {
		String expected="INITIATED";
		CourierEntity testdata = new CourierEntity(4,5123,LocalDate.parse("2020-11-03"),LocalDate.parse("2021-03-20"),CourierStatus.INITIATED);
		int courierid = 4;
		Mockito.when(courierRepo.existsById(courierid)).thenReturn(true);
		Mockito.when(courierRepo.findById(courierid)).thenReturn(Optional.of(testdata));
		String actual = spImpl.checkShipmentStatus(testdata.getCourierId());
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("ShipmentServiceImpl:: closeShipmentTransaction should return true if courier status is successfully changed to delivered")
	void closeShipmentTransaction() throws CourierNotFoundException {
		boolean expected = true;
		CourierEntity testdata = new CourierEntity(1,5000,LocalDate.parse("2020-11-03"),LocalDate.parse("2021-03-20"));
		Mockito.when(courierRepo.existsById(testdata.getCourierId())).thenReturn(true);
		Mockito.when(courierRepo.findById(testdata.getCourierId())).thenReturn(Optional.of(testdata));
		boolean actual = spImpl.initiateShipmentTransaction(testdata.getCourierId());
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("ShipmentServiceImpl:: rejectShipmentTransaction should return true if courier status is successfully changed to rejected")
	void rejectShipmentTransaction() throws CourierNotFoundException {
		boolean expected = true;
		CourierEntity testdata = new CourierEntity(1,5000,LocalDate.parse("2020-11-03"),LocalDate.parse("2021-03-20"));
		Mockito.when(courierRepo.existsById(testdata.getCourierId())).thenReturn(true);
		Mockito.when(courierRepo.findById(testdata.getCourierId())).thenReturn(Optional.of(testdata));
		boolean actual = spImpl.initiateShipmentTransaction(testdata.getCourierId());
		assertEquals(expected, actual);
	}

}
