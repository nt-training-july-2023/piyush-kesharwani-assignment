package ComparatorExample;

import java.util.ArrayList;
import java.util.Collections;

class Employee{
	int empid;
	String name;
	int salary;
	
	Employee(int empid, String name,int salary){
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		
	}
}


public class comparatorLogic {
	public static void main(String[] args) {
		ArrayList<Employee> arr = new ArrayList<>();
		
		arr.add(new Employee(900,"Varun",59000));
		arr.add(new Employee(903,"Ravi",98000));
		arr.add(new Employee(834,"Aman",29000));
		arr.add(new Employee(670,"Kalki",20000));
		
		for(Employee e :arr) {
			System.out.println(e.empid + " " + e.name + " " + e.salary);
		}
		System.out.println("After sorting  by name - ");
		// sorting by name 
		Collections.sort(arr,new nameComp());
		for(Employee e :arr) {
			System.out.println(e.empid + " " + e.name + " " + e.salary);
		}
		
		System.out.println("After sorting by salary -");
		// sorting by salary
		Collections.sort(arr,new salaryComp());
		for(Employee e :arr) {
			System.out.println(e.empid + " " + e.name + " " + e.salary);
		}
		
	}

}
