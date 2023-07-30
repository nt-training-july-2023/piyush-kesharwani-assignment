package MAPS;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p1_iterateMaps {
	
	public static HashMap<Integer,String> add(){
		Scanner sc = new Scanner(System.in);
		HashMap<Integer,String> m = new HashMap<>();
		System.out.println("Enter the number of elements you want to add - ");
		int number = sc.nextInt();
		
		for(int i=1;i<=number;i++)
		{
			System.out.println("Enter id of employee "+i);
			int id = sc.nextInt();sc.nextLine();
			System.out.println("Enter name of employee "+i);
			String name = sc.nextLine();
			m.put(id, name);
		}
		return m;
	}
	
	public static void printElement(HashMap<Integer,String> hm) {
		System.out.println("The list of key and value is - ");
		for(Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}
	
	public static void main(String[] args) {
		
	  HashMap<Integer,String> h = new HashMap<>();
	   h = add();
	  printElement(h);
		
		
		
	}

}
