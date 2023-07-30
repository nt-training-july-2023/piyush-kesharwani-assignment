package inputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInput {
  public static void main(String[] args) {
	try {
		
	  FileInputStream fm = new FileInputStream("C:\\Users\\Piyush\\eclipse-workspace\\FileInputOutput\\src\\inputStream\\input.txt");
	  BufferedInputStream bs = new BufferedInputStream(fm);
	  
	  int i=0;
	  while((i=bs.read())!= -1) {
//		  System.out.print(i); // return in byte
		  System.out.print((char)i);
	  }
	  bs.close();
	  fm.close();
	  
	}catch(Exception e) {
		System.out.println(e);
	}
}
}
