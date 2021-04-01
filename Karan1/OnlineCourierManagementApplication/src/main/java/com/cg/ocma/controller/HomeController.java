package com.cg.ocma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"","/","/home"})
@CrossOrigin
public class HomeController {
	
	@GetMapping
	public ResponseEntity <String> defaultAction(){

		return new ResponseEntity <> ("Welcome to Online Courier Management Application", HttpStatus.OK);

	}

}
