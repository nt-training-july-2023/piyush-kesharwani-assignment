package MAPS;

import java.util.HashMap;
import java.util.Scanner;

public class thresholdMap {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void add(HashMap<Integer,String> hm,int number) {
		 
		for(int i=1;i<=number;i++)
		{
			System.out.println("Enter id of employee "+i);
			int id = sc.nextInt();sc.nextLine();
			System.out.println("Enter name of employee "+i);
			String name = sc.nextLine();
			hm.put(id, name);
		}
		System.out.println("The element of hashmap are - ");
		System.out.println(hm);
	}
	
	static HashMap<Integer,String> remove(HashMap<Integer,String> hh , int si) {
		if(hh.size()>=si) {
			System.out.println("Size of hashmap is greater than threshold so ");
			hh.clear();
		}
		return hh;
	}
	
	public static void main(String[] args) {
		HashMap<Integer,String> hh = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Threshold size - ");
		int ts = scan.nextInt();
		
		add(hh,4);
		
		System.out.println("after comparing with threshold value - map elements are -");
		System.out.println(remove(hh,ts));
		
		
		
	}

}
