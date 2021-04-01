  
package com.cg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.AddressEntity;

@Repository
public interface AddressRepo extends JpaRepository <AddressEntity,Integer>{

}