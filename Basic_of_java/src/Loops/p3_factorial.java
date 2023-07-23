package Loops;

import java.util.Scanner;

public class p3_factorial {
	public static void main(String[] args) {
		System.out.println("Enter the number - ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int fact=1;
		
		for(int i=0;i<n;i++){
			fact = fact*(n-i);
		}
		System.out.println("the factorial of " + n + " -> " + fact);
	}

}
