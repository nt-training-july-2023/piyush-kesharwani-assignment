package Loops;

import java.util.Scanner;

public class p4_Armstrong {
	
	static boolean isArmstrong(int n) {
		int temp , digit=0,sum=0,last=0;
		temp=n;
		while(temp>0) {
			temp = temp/10;
			digit++;
		}
		temp=n;
		while(temp>0) {
			last = temp%10;
			sum = (int) (sum + (Math.pow(last, digit)));
			temp = temp/10;
		}
		if(sum==n) {
			return true;
		}
		else return false;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number - ");
		int n = sc.nextInt();
		if(isArmstrong(n))  
		{  
		System.out.print(n + " is a Armstrong number ");  
		}  
		else   
		{  
		System.out.print(n+ " is not a Armstrong number ");  
		}  
	}
}


