package copy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class copyOfFile {
	public static void main(String[] args) {
		try {
			FileReader f = new FileReader("C:\\Users\\Piyush\\eclipse-workspace\\FileInputOutput\\src\\copy\\file1");
			FileWriter fw = new FileWriter("C:\\Users\\Piyush\\eclipse-workspace\\FileInputOutput\\src\\copy\\file2");
			
			int i=0;
			while((i=f.read())!= -1) {
				fw.write(i);
			}
			f.close();
			fw.close();
			System.out.println("Copying from 1 file to another is done....");
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

}
