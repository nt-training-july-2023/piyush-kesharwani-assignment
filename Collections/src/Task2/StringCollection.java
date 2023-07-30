package Task2;

import java.util.Scanner;
import java.util.TreeSet;

public class StringCollection {
	public static void main(String[] args) {
		TreeSet<String> st = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string value -");
	    for(int i=0;i<5;i++) {
	    	st.add(sc.next());
	    }
		System.out.println("the elements are - ");
		System.out.println(st);
	}

}
