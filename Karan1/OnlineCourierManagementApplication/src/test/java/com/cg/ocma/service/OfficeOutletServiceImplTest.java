package com.cg.ocma.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.ocma.exception.DuplicateOfficeOutletFoundException;
import com.cg.ocma.exception.OutletNotFoundException;
import com.cg.ocma.model.CourierOfficeOutletModel;
import com.cg.ocma.repository.OfficeOutletRepo;

@ExtendWith(MockitoExtension.class)
public class OfficeOutletServiceImplTest {
	
	@Mock
	private OfficeOutletRepo officeRepo;
	
	@InjectMocks
	private OfficeOutletServiceImpl ofImpl;
	
	@Test
	@DisplayName("OfficeOutletServiceImpl:: addNewOfficeCheck should return exception if the officeid already exists")
	void addNewOfficeCheck() throws DuplicateOfficeOutletFoundException{
		
		CourierOfficeOutletModel check = new CourierOfficeOutletModel(2,"08:30:00","22:00:00");
		Mockito.when(officeRepo.existsById(check.getOfficeid())).thenReturn(true);
		assertThrows(DuplicateOfficeOutletFoundException.class, () -> {
			ofImpl.addNewOffice(check);
		});
	}
	
	@Test
	@DisplayName("OfficeOutletServiceImpl:: removeNewOffice should return true if the office object is successfully deleted")
	void removeNewOffice() throws OutletNotFoundException{
		int testdata = 6;
		Mockito.when(officeRepo.existsById(testdata)).thenReturn(true);
		assertTrue(ofImpl.removeNewOffice(testdata));
	}
	
	@Test
	@DisplayName("OfficeOutletServiceImpl:: getOfficeInfoCheck should return exception if the office object doesn't exist")
	void getOfficeInfoCheck() throws OutletNotFoundException{
		int testdata = 6;
		Mockito.when(officeRepo.existsById(testdata)).thenReturn(false);
		assertThrows(OutletNotFoundException.class, () -> {
			ofImpl.getOfficeInfo(testdata);
		});

		
	}
	
	@Test
	@DisplayName("OfficeOutletServiceImpl:: getAllOfficesCheck should return exception if the office objects don't exist")
	void getAllOfficesCheck() throws OutletNotFoundException{
		Mockito.when(officeRepo.count()).thenReturn(0L);
		assertThrows(OutletNotFoundException.class, () -> {
			ofImpl.getAllOfficesData();
		});

		
	}
}
