package p7_ArrayException;

import java.util.Scanner;

public class arrayException {
	 public static void main(String[] args) {
			Integer[] arr = {17,16,null,90,11,null};
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the index of string array to fetch the details - ");
			
			try {
				int index = sc.nextInt();
				if(arr[index]==null) {
					throw new NullPointerException("The value at this index is null");
				}
				else if(index>arr.length) {
					throw new IndexOutOfBoundsException("invalid index...");
				}
				else {
					System.out.println("The value at index is = " + arr[index]);
				}
				
			}catch(NullPointerException e) {
				System.out.println(e.getMessage());
				
			}
			catch(IndexOutOfBoundsException ex) {
				System.out.println(ex.getMessage());
			}
			
		}
}
