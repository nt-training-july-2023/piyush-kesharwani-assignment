package MAPS;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class CRUDoperation {
	
	static void hashmap(HashMap<Integer,String> hm) {
		
	// adding key-value pair into hashmap
		hm.put(1,"Akash");
		hm.put(2,"Aman");
		hm.put(3,"Ravi");
		hm.put(4,"Kavi");
		
		System.out.println(hm);
   // update the key-value pair 
		//hm.replace(5, "Vishal"); // we can only update from existing element 
		hm.replace(4, "karan");
		
		System.out.println("After update the map is - ");
		System.out.println(hm);
		
    // delete element from hashmap
		hm.remove(2);
		System.out.println("After removing the key 2 - ");
		System.out.println(hm);
		
	}
	
	static void linkedhash(LinkedHashMap<Integer,String> lhm) {
		
		// adding element in linkedhash map
		lhm.put(101, "Aakash");
		lhm.put(102, "rohit");
		lhm.put(103, "Arjun");
		lhm.put(104, "vini");
		System.out.println(lhm);
		
		// update the element
		System.out.println("After updating the element -");
		lhm.replace(103, "lisa");
		System.out.println(lhm);
		
		// delete the element
		System.out.println("After deleting the element -");
		lhm.remove(102);
		System.out.println(lhm);
	}
	
static void treemap(TreeMap<Integer,String> tm) {
		
		// adding element in tree map
		tm.put(201, "Aakash");
		tm.put(222, "rohit");
		tm.put(203, "Arjun");
		tm.put(214, "vini");
		System.out.println(tm);
		
		// update the element
		System.out.println("After updating the element -");
		tm.replace(203, "lisa");
		System.out.println(tm);
		
		// delete the element
		System.out.println("After deleting the element -");
		tm.remove(102);
		System.out.println(tm);
	}
	
  public static void main(String[] args) {

	  // creating the HashMap;
//	 HashMap<Integer,String> hh = new HashMap<>();
//	 hashmap(hh);
	  
	  // creating the linkedhashMap
//	  LinkedHashMap<Integer,String> ll = new LinkedHashMap<>();
//	  linkedhash(ll);
	  
	  //creating the TreeMap
	  
	  // arrange elements in ascending order
	  TreeMap<Integer,String> t = new TreeMap<>();
	  treemap(t);
}
}
