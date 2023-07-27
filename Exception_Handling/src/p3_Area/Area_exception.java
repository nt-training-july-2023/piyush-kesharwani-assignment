package p3_Area;

import java.util.Scanner;

public class Area_exception {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the length - ");
	int l = sc.nextInt();
	System.out.println("Enter the breadth - ");
	int b = sc.nextInt();
	
	try {
		if(l<=0) {
			throw new InvalidDimensionException("Invalid!!!! dimension value");
		}
		else if(b<=0) {
			throw new InvalidDimensionException("Invalid!!!! dimension value");
		}
		else {
			int ar = l*b;
			System.out.println("Area is  - "+ ar);
		}
	}catch(InvalidDimensionException e) {
		System.out.println(e.getMessage());
	}
}
}
