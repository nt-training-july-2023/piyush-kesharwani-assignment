package Filter;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

public class filterOutput {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Piyush\\eclipse-workspace\\FileInputOutput\\src\\Filter\\newout");
		FilterOutputStream fosss = new FilterOutputStream(fos);
		String str = "I AM  a filter output stream ";
		byte[] b = str.getBytes();
		fosss.write(b);
	    fosss.close();
	    fos.close();
	    System.out.println("done.....");
		
	}

}
