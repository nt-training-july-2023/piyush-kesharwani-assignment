package getList;

import java.io.File;

public class listOfDirectories {
	public static void main(String[] args) {
		File f = new File("C:\\Users\\Piyush\\eclipse-workspace\\FileInputOutput\\src");
		String[] getstr = f.list();
		
		for(String s : getstr) {
			System.out.println(s);
		}
		
	}

}
