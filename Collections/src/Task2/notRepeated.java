package Task2;

import java.util.TreeSet;

public class notRepeated {
   public static void main(String[] args) {
	TreeSet<String> st  =new TreeSet<>();
	st.add("Karan");
	st.add("naira");
	st.add("Bagga");
	st.add("Trippy");
	st.add("Karan");  //repeation not allowed
	st.add("naira");
	
	System.out.println(st);
}
}
