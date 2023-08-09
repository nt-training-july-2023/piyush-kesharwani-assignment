package com.EmployeeAssignment.CRUD.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.EmployeeAssignment.CRUD.dao.EmpRepository;
import com.EmployeeAssignment.CRUD.entities.EmployeeEntity;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepository Erepo;
	
	// for getting all employee details
	public List<EmployeeEntity> getAllEmp(){
		List<EmployeeEntity> l = (List<EmployeeEntity>) this.Erepo.findAll();
		return l;
	}
	
	// get employee by id
	public EmployeeEntity getById(int id) {
		return Erepo.findById(id).get();
	}
	
	// adding employee details
	public EmployeeEntity addEmp(EmployeeEntity emp) {
		
		return Erepo.save(emp);
	}
	
	// delete the employee by id
	public void deleteEmp(int id) {
		
		 Erepo.deleteById(id);
	}
	
	//updating the employee details
	public String updateEmp(EmployeeEntity emp ,int id) {
		emp.setEmpId(id);
		Erepo.save(emp);
		return "employee details updated";
	}

}
