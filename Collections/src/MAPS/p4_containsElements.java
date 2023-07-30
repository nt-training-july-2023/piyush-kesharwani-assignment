package MAPS;

import java.util.HashMap;

public class p4_containsElements {
	public static void main(String[] args) {
		HashMap<Integer,String> mapp = new HashMap<>();
		
		mapp.put(1,"Akash");
		mapp.put(2,"Aman");
		mapp.put(3,"Ravi");
		mapp.put(4,"Kavi");
		 
		System.out.println(mapp);
		
		// check contains key
		System.out.println("The map contains key 3 - " + mapp.containsKey(3));
		System.out.println("The map contains key 5 - " + mapp.containsKey(5));
		
	   // check contains value
		System.out.println("the map contains Aman - "  + mapp.containsValue("Aman"));
		System.out.println("the map contains Ayush - " + mapp.containsValue("Ayush"));
	}

}
