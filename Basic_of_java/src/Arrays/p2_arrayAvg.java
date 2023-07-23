package Arrays;

import java.util.Scanner;

public class p2_arrayAvg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the arrays elements -");
		int[] arr = new int[5];
		for(int i=0;i<5;i++) {
			arr[i] = sc.nextInt();
		}
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
		}
		float avg = sum/arr.length;
		System.out.println("The average of array elements is - " + avg);
	}

}
