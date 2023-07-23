package Loops;

import java.util.Scanner;

public class p6_palindrome {
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
		if(n==rev) {
			System.out.println(n + " is a Pallindrome");
		}
		else {
			System.out.println(n + " is not a pallindrome");
		}
}
}
