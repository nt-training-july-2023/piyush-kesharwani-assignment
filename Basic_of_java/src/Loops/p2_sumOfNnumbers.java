package Loops;

import java.util.Scanner;

public class p2_sumOfNnumbers {
	public static void main(String[] args) {
		System.out.println("Enter the number - ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum=0;
		int i=0;
		while(i<n) {
			sum += i;
			i++;
		}
		System.out.println("The sum of first n number is - "  + sum);
	}

}
