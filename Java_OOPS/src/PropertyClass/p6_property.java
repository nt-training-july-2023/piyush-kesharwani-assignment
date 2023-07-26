package PropertyClass;

import java.util.*;  
import java.io.*;  

public class p6_property {
	public static void main(String[] args) throws FileNotFoundException {
		 FileReader reader= new FileReader("C:\\Users\\Piyush\\eclipse-workspace\\Java_OOPS\\src\\PropertyClass\\db.properties");  
	      
		    Properties p=new Properties();  
		    try {
				p.load(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}  
		      
		    System.out.println("The email of a employee is " + p.getProperty("email"));  
		    System.out.println("the name of a employee is " + p.getProperty("name"));
		    System.out.println("the date of joining of a employee is " + p.getProperty("system"));
		    
	}

}
