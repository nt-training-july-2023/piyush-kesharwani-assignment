package outputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutput {
  public static void main(String[] args) {
	try {
	 byte[] word = {12,45,64,78};
	 BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream("C:\\Users\\Piyush\\eclipse-workspace\\FileInputOutput\\src\\outputStream\\buffer.txt"));
//	 bs.write(word);
	 
	 for(int i=0;i<word.length;i++) {
		 bs.write(word);
	 }
	 System.out.println("Writing completed...");
	 bs.close();
	
	}catch(Exception e) {
		System.out.println(e);
	}
}
}
