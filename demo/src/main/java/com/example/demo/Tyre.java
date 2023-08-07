package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Tyre {
  String brand;

  // for constructor injection
  
   public Tyre(String brand) {
	super();
	this.brand = brand;
}


public String getBrand() {
	   return brand;
    }

   
   //for setter injection
   public void setBrand(String brand) {
	   this.brand = brand;
    }

@Override
public String toString() {
	return "Tyre [brand=" + brand + "]";
}
   
   
  
}
