package com.cg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.CourierEntity;

@Repository
public interface CourierRepo extends JpaRepository <CourierEntity,Integer>{
	
	//@Query("SELECT c FROM Customer c WHERE (SELECT customerid FROM Courier WHERE courierid = ?)")
	//public Customer findCustomer(int courierid);
	public CourierEntity findByConsignmentNo(int consignmentno);
	public boolean existsByConsignmentNo(int consignmentno);

}