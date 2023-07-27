package p9_EvenOddException;

import java.util.Scanner;

public class evenOddtest {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number - ");
	int n = sc.nextInt();
	
	try {
		if(n%2==0) {
			System.out.println("Its an Even number.");
		}
		else {
			throw new NotEvenNumberException("Its not an even number..");
		}
	}
	catch(NotEvenNumberException e) {
		System.out.println(e);
	}
}
}
