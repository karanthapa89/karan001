package com.cg.ocma.service;

public interface IPaymentService {
	
	public boolean processByCash();
	public boolean processByCard(int customerid);  

}
