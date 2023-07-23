package Arrays;

import java.util.Scanner;

public class p1_LargestNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the arrays elements -");
		int[] arr = new int[5];
		for(int i=0;i<5;i++) {
			arr[i] = sc.nextInt();
		}
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		System.out.println("the largest element of array is - " + max);
		
  }

}
