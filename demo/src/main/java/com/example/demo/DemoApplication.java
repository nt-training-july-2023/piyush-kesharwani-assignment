package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
//		Car c = new Car();
//		c.drive();
		
//		Bike b = new Bike();
//		b.ride();
		
		// getBean can be provided by BeanFactory as well as ApplicationContext
		//BeanFactory bf = new BeanFactory();
		
		ClassPathXmlApplicationContext ap = new ClassPathXmlApplicationContext("Spring.xml");
		
		// for xml based configuration
//		Vehicle obj = (Vehicle)ap.getBean("vehicle");
		
		// annotation based configuration
//		Vehicle obj = (Vehicle)ap.getBean("car");
//		obj.drive();
		
//		Tyre t = (Tyre)ap.getBean("tyre");
//		System.out.println(t);
		
		
		//AutoWired
		Car obj = (Car)ap.getBean("car");
		obj.drive();
	}

}
