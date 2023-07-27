package FileExceptionHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class p5_IOException {
  public static void main(String[] args) throws IOException {
	FileInputStream ins = new FileInputStream("C:\\Users\\Piyush\\eclipse-workspace\\Exception_Handling\\src\\FileExceptionHandling\\set.txt");
	FileOutputStream ous = new FileOutputStream("C:\\Users\\Piyush\\eclipse-workspace\\Exception_Handling\\src\\FileExceptionHandling\\get.txt");
	
	// copying from text file to get file
	try {
		int i=0;
		
		while((i=ins.read())!=-1) {
			ous.write(i);
		}
		System.out.println("Copying successfull...");
		
	}
	catch(Exception e) {
		System.out.println(e + "Exception occur..");
	}
	finally {
		if(ins!=null) {
			ins.close();
		}
		if(ous!=null) {
			ous.close();
		}
	}
	
	
	
}
}
