package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle  {
	
	@Autowired
	private Tyre ty;
	
	public Tyre getTy() {
	 	return ty;
	 }

	public void setTy(Tyre ty) {
		this.ty = ty;
	}



public void drive() {
	   System.out.println("ITsss workinggg..." + ty);
   }
}
