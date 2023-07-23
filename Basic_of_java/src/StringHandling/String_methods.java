package StringHandling;

public class String_methods {
	public static void main(String[] args) {
		
		String str = "Lets Explore STRINGS Methods";
		System.out.println(str);
		
		// string method toLowerCase - returns string in lowercase letters
		System.out.println("String after using tolowerCase ->" + str.toLowerCase());
		
		// string method toUpperCase - return string in uppercase letters
		System.out.println("String after using tolowerCase ->" + str.toUpperCase());
		
		// string splits methods - splits this string against given regular expression
		System.out.println("After using splits -> ");
		String [] arrstr = str.split(" ");
		for(String s : arrstr) {
			System.out.println(s);
		}
		
		// string isEmpty methods - return true or false
		System.out.println("Is str string is empty -> " + str.isEmpty());
	}

}
