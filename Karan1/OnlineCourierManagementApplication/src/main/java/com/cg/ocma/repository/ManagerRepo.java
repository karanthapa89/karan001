  
package com.cg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.OfficeStaffMembersEntity;

@Repository
public interface ManagerRepo extends JpaRepository <OfficeStaffMembersEntity, Integer>{

}