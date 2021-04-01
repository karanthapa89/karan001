package com.cg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ocma.repository.CustomerRepo;

@Service
public class PaymentServiceImpl implements IPaymentService {
	
	@Autowired
	private CustomerRepo customerRepo;

	public PaymentServiceImpl() {
		/* No implementation */
	}

	public PaymentServiceImpl(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	@Override
	public boolean processByCash() {
		
		return true;
	}

	@Override
	public boolean processByCard(int customerid) {
		
		boolean flag = false;
		
		if(customerRepo.existsById(customerid)) {
			
			if(customerRepo.findById(customerid).orElse(null).getAcct() != null) {
				flag = true;
				
			}else {
				
				flag = false;
			}
			
		}
		
		return flag;
	}

}
