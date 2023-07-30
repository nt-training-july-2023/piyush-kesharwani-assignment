package MAPS;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class p6_remove {
  public static void main(String[] args) {
	HashMap<Integer,String> hhh = new HashMap<>();
	hhh.put(1,"Akash");
	hhh.put(2,"Aman");
	hhh.put(3,"Ravi");
	hhh.put(4,"Kavi");
	
	Scanner sc = new Scanner(System.in);
	System.out.println(hhh);
	System.out.println("enter the value - ");
	String value = sc.next();
	
	Iterator it = hhh.entrySet().iterator();
	while(it.hasNext())
	{
		Map.Entry entry = (Map.Entry)it.next();
		if(value.equals(entry.getValue()))
		{
			it.remove();
		}
	}
	System.out.println(hhh);
	
}
}
