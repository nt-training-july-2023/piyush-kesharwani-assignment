package inputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class fileInputStream {
  public static void main(String[] args) throws FileNotFoundException {
	 FileInputStream in = new FileInputStream("C:\\Users\\Piyush\\eclipse-workspace\\FileInputOutput\\src\\inputStream\\input.txt");
     
	 try {
		 int n=0;
		 
		 // reading all character
		 while((n=in.read())!= -1) {
			 System.out.print((char)n);
		 }
		 
//		 int ans = in.read();  // reading only single character
//		 System.out.println((char)ans);
		 
		 in.close();
	 }catch(IOException e) {
		 System.out.println(e);
	 }
}
}
