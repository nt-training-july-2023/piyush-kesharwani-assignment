package Loops;

import java.util.Scanner;

public class p5_reverseNumber {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number - ");
	int n = sc.nextInt();
	
	int rev = 0;
	int temp = n;
	while(temp>0) {
		int rem = temp%10;
		rev = rev*10 + rem;
		temp = temp/10;
	}
	System.out.println("The reverse of the number " + n + " is " + rev);
	
	
}
}
