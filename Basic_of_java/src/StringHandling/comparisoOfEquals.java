package StringHandling;

public class comparisoOfEquals {
	public static void main(String[] args) {
		String s = "Yash";
		String s2 = "Yash";
		String s3 = new String("Yash");
		String s4 = "Ajay";
		
		// equals() methods -
         System.out.println(s.equals(s2));
         System.out.println(s.equals(s3));
         System.out.println(s.equals(s4));
       
       // == operator
         System.out.println("after using == operator");
         System.out.println(s==s2);
         System.out.println(s==s3);
         System.out.println(s==s4);
	}

}
