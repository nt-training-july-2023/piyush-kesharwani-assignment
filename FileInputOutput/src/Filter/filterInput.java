package Filter;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;

public class filterInput {
	public static void main(String[] args) {
		try {
			FileInputStream fms = new FileInputStream("C:\\Users\\Piyush\\eclipse-workspace\\FileInputOutput\\src\\Filter\\filin");
			FilterInputStream fi = new BufferedInputStream(fms);
			
			int i=0;
			while((i=fi.read())!= -1) {
				System.out.print((char)i);
			}
			fi.close();
			fms.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
