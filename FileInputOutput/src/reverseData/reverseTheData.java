	package reverseData;

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.util.ArrayList;
	import java.util.Collections;

	public class reverseTheData {
		public static void main(String[] args) {
			try {
				FileReader fr = new FileReader("C:\\Users\\Piyush\\eclipse-workspace\\FileInputOutput\\src\\reverseData\\orgdata");
				BufferedReader reader = new BufferedReader(fr);
				String originalData;
				ArrayList<String> a = new ArrayList<String>();
				while((originalData = reader.readLine())!=null)
				{
					a.add(originalData);
				}
				Collections.reverse(a);
				FileWriter fw = new FileWriter("C:\\Users\\Piyush\\eclipse-workspace\\FileInputOutput\\src\\reverseData\\revdata");
				BufferedWriter bw = new BufferedWriter(fw);
				for(String s:a)
				{
					bw.write(s);
					bw.newLine();
				}
				bw.close();
				reader.close();
				System.out.println("data is reversed...");
			}catch(Exception e) {
				System.out.println(e);
			}
		}

	}



