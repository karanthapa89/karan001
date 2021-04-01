package com.cg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.CustomerEntity;

@Repository
public interface CustomerRepo extends JpaRepository <CustomerEntity,Integer>{
	
}