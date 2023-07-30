package outputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileOutputStream {
  public static void main(String[] args) {
	 try {
		
	    FileOutputStream fo = new FileOutputStream("C:\\Users\\Piyush\\eclipse-workspace\\FileInputOutput\\src\\outputStream\\output.txt");	 
//      fo.write(123);
	    fo.write(66);
//	    fo.write(124);
		 fo.close();
		 
	 }catch(FileNotFoundException e ) {
		 System.out.println(e);
	 }catch(IOException ex) {
		 System.out.println(ex);
	 }
}
}
