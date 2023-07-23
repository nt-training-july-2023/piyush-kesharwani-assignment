package StringHandling;

public class string_operations {
	public static void main(String[] args) {
		String str = "Hello World";
		
		// String length
		int length = str.length();
		System.out.println("the length of given string is - " + length);
		
		//string concatenation
		 String str2 = " welcome to nucleusTeq";
		 String result = str.concat(str2);
		 System.out.println("After concatenation - ");
		 System.out.println(result);
       
		// get a character from a given position of a string
		// lets get a character from position 7
		 
		 char c = str.charAt(7);
		 System.out.println("the char at position 3 is - " + c);
         
		// check if a string start with a given character or a string
		 // check if given string  starts with hell
		 
		 System.out.println("Is the str string starts with Hel - " + str.startsWith("Hel"));
		 System.out.println("Is the str2 string starts with Hel - " + str2.startsWith("Hel"));
		 
		 
		 //Find index of a given character or string from a String.
		 // get index of char W
		 
		 System.out.println("the index of char W is " + str.indexOf('W'));
		 
		 // get index of string Teq from str2
		 
		 System.out.println("The index of string Teq is - " + str2.indexOf("Teq"));
		 
		 //Replace a character from a String
		 // lets replace char o with char a
		 
		 
		 System.out.println(str.replace('o', 'a'));
	}


}
