package com.assignment.CRUD;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.assignment.CRUD.entities.User;
import com.assignment.CRUD.repo.UserRepository;

@SpringBootApplication
public class CruDoperationApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CruDoperationApplication.class, args);
		
		UserRepository userrepo = context.getBean(UserRepository.class);
		
		//creating object of class User
//		User u1 = new User();
//		u1.setEname("Rohan");
//		u1.setSalary(30000);
//		u1.setDepartment("java programmer");
//		
//		User u2 = new User();
//		u2.setEname("Raj");
//		u2.setSalary(40000);
//		u2.setDepartment("python programmer");
//		
//		User user = userrepo.save(u1);
//		User user2 = userrepo.save(u2);
//		
//		System.out.println(user);
//		System.out.println(user2);
		
		// updating the element 
		
//		Optional<User> o = userrepo.findById(1);
//		User u3 = o.get();
//		u3.setEname("Rohan singh");
//		userrepo.save(u3);
		
		// fetching the data
		//fetching the single data by id
		
//		Optional<User> u4 = userrepo.findById(1);
//		System.out.println(u4);
		
		
		// fetching all the data
		Iterable<User> itr = userrepo.findAll();
		
		itr.forEach(User -> {System.out.println(User);});
		
		//deleting the element from database
		
		//by id 
		userrepo.deleteById(2);
		 System.out.println("Element is Deleted");
		 
		 System.out.println("After deleting the remaining data is -");
		
		 Iterable<User> itr2 = userrepo.findAll();
			
			itr2.forEach(User -> {System.out.println(User);});
		
	}

}
