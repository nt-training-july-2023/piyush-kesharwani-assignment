package MAPS;

import java.util.HashMap;
import java.util.Map;

public class p5_retriveElements {
	public static void main(String[] args) {
       HashMap<Integer,String> mapp = new HashMap<>();
		
		mapp.put(1,"Akash");
		mapp.put(2,"Aman");
		mapp.put(3,"Ravi");
		mapp.put(4,"Kavi");
		 
		System.out.println(mapp);
		
		//Retrieving the key
		System.out.println("All the keys present in map are - ");
		for(Map.Entry m : mapp.entrySet()) {
			System.out.print(m.getKey()+ " ");
		}
		System.out.println();
		
		// retrieving the value
		System.out.println("All the values present in map are - ");
		for(Map.Entry m : mapp.entrySet()) {
			System.out.print(m.getValue()+ " ");
		}
	}

}
