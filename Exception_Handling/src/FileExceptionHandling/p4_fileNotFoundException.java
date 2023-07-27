package FileExceptionHandling;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class p4_fileNotFoundException {
	public static void main(String[] args) throws FileNotFoundException {
		
		try {
			
	// when we giving correct path - its does not show filenotFoundException
	//	FileReader fr1 = new FileReader("C:\\Users\\Piyush\\eclipse-workspace\\Exception_Handling\\src\\FileExceptionHandling\\text.txt");
		
	 // when we giving wrong path...	
	  FileReader fr = new FileReader("C:\\Users\\Piyush\\eclipse-workspace\\Exception_Handling\\src\\FileExceptionHandling\\text.txt\\");
		
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

}
}
