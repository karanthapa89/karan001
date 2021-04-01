package com.cg.ocma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ocma.service.IPaymentService;

@RestController
@RequestMapping("/home/customer/{customerid}/initiate")
@CrossOrigin
public class PaymentRestController {
	
	@Autowired
	private IPaymentService paymentService;
	
	@GetMapping("byCash")
	public ResponseEntity <String> processByCash() {
		
		return new ResponseEntity <> ("You have chosen cash on delivery. Kindly pay once the courier is delivered", HttpStatus.OK);
	}
	
	@GetMapping("byCard")
	public ResponseEntity <String> processByCard(@RequestBody int customerid) {
		
		boolean flag = paymentService.processByCard(customerid);
		if(flag) {
			
			return new ResponseEntity <> ("You have successfully paid by card. Kindly wait for the courier to be delivered.", HttpStatus.OK);
		} else {
			
			return new ResponseEntity <> ("Sorry! You are not eligible to pay by card, please pay the amount once the courier is received.", HttpStatus.OK);
		}
		
	}

}
