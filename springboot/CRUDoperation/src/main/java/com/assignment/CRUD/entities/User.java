package com.assignment.CRUD.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
   

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Ename;
	private int  salary;
	private String department;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String ename, int salary, String department) {
		super();
		this.id = id;
		Ename = ename;
		this.salary = salary;
		this.department = department;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", Ename=" + Ename + ", salary=" + salary + ", department=" + department + "]";
	}
	
}
