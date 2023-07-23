package Loops;

import java.util.Scanner;

public class p1_MultiplicationTable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number - ");
		int n = sc.nextInt();
		
		
		for(int i=1;i<11;i++) {
			System.out.println(n + " x " + i + " = " + (n*i));
		}
		
	}

}
