package operatorAndExpression;

import java.util.Scanner;

//write a program to find out the area of a triangle. take base and height as input

public class problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the base of traingle -");
		int b = sc.nextInt();
		System.out.println("Enter the height of traingle -");
		int h = sc.nextInt();
		
		int area = (b*h)/2;
		System.out.println("The area of triangle is = " + area);
	}

}
