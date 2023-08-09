package com.EmployeeAssignment.CRUD.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
public class EmployeeEntity {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int EmpId;
	private String Ename;
	private int salary;
	private String dept; 
	

	public EmployeeEntity() {
		super();
	}
	
	public EmployeeEntity(int empId, String ename, int salary, String dept) {
		super();
		EmpId = empId;
		Ename = ename;
		this.salary = salary;
		this.dept = dept;
	}

	public int getEmpId() {
		return EmpId;
	}

	public void setEmpId(int empId) {
		EmpId = empId;
	}

	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [EmpId=" + EmpId + ", Ename=" + Ename + ", salary=" + salary + ", dept=" + dept + "]";
	}

}
