package Task2;

import java.util.HashSet;

public class methods {
	 public static void main(String[] args) {
		HashSet<String> hsss = new HashSet<>();
		hsss.add("Karan");
		hsss.add("naira");
		hsss.add("Bagga");
		hsss.add("Trippy");
		hsss.add("Karan");  //repeation not allowed
		hsss.add("naira");
		
		System.out.println("the elements are - ");
		System.out.println(hsss);
		
		hsss.remove("Trippy");
		System.out.println("After removing one elements ");
		System.out.println(hsss);
		
//		hs.removeAll(hsss);
		System.out.println(hsss);
		
		System.out.println("Tree contains karan - " + hsss.contains("Karan"));
		
		HashSet<String> hsss2 = new HashSet<String>();
		
		hsss2.addAll(hsss);
		System.out.println("Copying from one set to another -");
		System.out.println(hsss2);
		
	}

}
