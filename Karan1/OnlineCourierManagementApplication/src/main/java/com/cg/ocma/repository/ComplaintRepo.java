package com.cg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.ComplaintEntity;

@Repository
public interface ComplaintRepo extends JpaRepository <ComplaintEntity,Integer>{

}