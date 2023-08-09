package com.EmployeeAssignment.CRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeAssignment.CRUD.entities.EmployeeEntity;
@Repository
public interface EmpRepository extends JpaRepository<EmployeeEntity,Integer>{
//   public EmployeeEntity findById(int id);
}
