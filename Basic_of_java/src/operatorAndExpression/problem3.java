package operatorAndExpression;

import java.util.Scanner;

// write a program to find out the roots of the quadratic equation .
// Equation is ax^2 + bx +c =0 

public class problem3 {
 public static void main(String[] args) {
	
	 Scanner sc = new Scanner(System.in);
	 System.out.println("Enter the value of a = ");
	 int a = sc.nextInt();
	 System.out.println("Enter the value of b = ");
	 int b = sc.nextInt();
	 System.out.println("Enter the value of c = ");
	 int c = sc.nextInt();
	 
	 double root1 = (-b + Math.sqrt((b*b)-4*a*c))/2*a;
	 double root2 = (-b - Math.sqrt((b*b)-4*a*c))/2*a;
	 
	 System.out.println("The quation is -> " + a+"x^2"+ "+" +b+"x"+ "+" +c + "=0");
	 System.out.println("the roots is = " + root1 + " , "+ root2);
	 
	 
}
}
