package Task2;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class insertionOrder {
   public static void main(String[] args) {
	LinkedHashSet<String> lhs = new LinkedHashSet<>();
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the elements");
	
	for(int i=0;i<5;i++) {
		lhs.add(sc.next());
	}
	
	System.out.println("Insertion order is maintained -");
	System.out.println(lhs);
	
	
}
}
