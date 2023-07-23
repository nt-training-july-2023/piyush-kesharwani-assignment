package Arrays;

import java.util.Scanner;

public class p3_rotateElements {
 public static void main(String[] args) {
	 System.out.println("Enter the array: ");
     int[] arr = new int[5];
     Scanner sc = new Scanner(System.in);
     for (int i =0; i<5; i++){
         arr[i] = sc.nextInt();
     }
     System.out.println("Before Rotation: ");
     for (int i =0; i<5; i++){
         System.out.print(" "+arr[i]);
     }
     System.out.println();
     
     for(int i =0; i<2; i++){
    	 int temp = arr[0];
         for(int j =1; j<5;  j++){
             arr[j-1] = arr[j];
             arr[j] = temp;
         }
         arr[arr.length-1] = temp;
     }
     System.out.println("After Rotation: ");
     for (int i =0; i<5; i++){
         System.out.print(" "+arr[i]);
     }
}
}
