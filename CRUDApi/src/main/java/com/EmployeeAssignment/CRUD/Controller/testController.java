package com.EmployeeAssignment.CRUD.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeAssignment.CRUD.entities.EmployeeEntity;
import com.EmployeeAssignment.CRUD.service.EmpService;


@RestController
@RequestMapping("/api/employee")
public class testController {
	
	@Autowired
	private EmpService eService;
	
	public testController(EmpService eService) {
		super();
		this.eService = eService;
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeEntity>>getEmp(){
		List<EmployeeEntity> l = eService.getAllEmp();
		if(l.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(l));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity>getEmp(@PathVariable("id") int id){
		EmployeeEntity e = eService.getById(id);
		if(e==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(e));
		
	}
	 
	@PostMapping
	public ResponseEntity<EmployeeEntity> addEmp(@RequestBody EmployeeEntity emp){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR)).build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteEmp(@PathVariable("id") int id){
		try {
			eService.deleteEmp(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR)).build();
		}
	}
	
    @PutMapping("{id}")
    public ResponseEntity<EmployeeEntity>updateEmp(@RequestBody EmployeeEntity emp , @PathVariable("id") int id){
    	try {
			eService.updateEmp(emp,id);
			return ResponseEntity.ok().body(emp);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR)).build();
		}
    }
}
