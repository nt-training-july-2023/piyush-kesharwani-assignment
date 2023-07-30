package TASK1;

import java.util.ArrayList;
import java.util.Scanner;

public class less60 {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements you want to add in list -");
		int n = sc.nextInt();
		System.out.println("enter the elements -");
		
		for(int i=0;i<n;i++) {
			arr.add(sc.nextInt());
		}
		
		System.out.println("the elements are - 2");
		System.out.println(arr);
		System.out.println("element greater than 60 are - ");
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)>60) {
				System.out.print(arr.get(i) + " ");
			}
		}
		
	}

}
