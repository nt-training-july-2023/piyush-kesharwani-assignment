package FileExceptionHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class p8_finallyIO {
  public static void main(String[] args) {
	  FileReader fr =null;
	  try {
		 fr = new FileReader("C:\\Users\\Piyush\\eclipse-workspace\\Exception_Handling\\src\\FileExceptionHandling\\text.txt\\");
			
			BufferedReader br = new BufferedReader(fr);
			
			String st = null;
		 	   try {  
	               while ((st = br.readLine()) != null)   
	              {  
	                 System.out.println(st);  
	              }  
		       }catch(IOException e) {
		    	     System.out.println(e + " ");
		           }
		    }catch(FileNotFoundException ex) {
		    	 System.out.println(ex + " File is not there..");
		     }
	      finally {
	    	  try {
	    		  fr.close();
	    	  }catch(IOException ioe) {
	    		  System.out.println(ioe + ioe.getMessage());
	    	  }
	      }
	
}
}
