package lambda;

@FunctionalInterface
interface meth{
	String replace(String s);
}

public class p1_replaceVowels {
   public static void main(String[] args) {
	   String str = "This is my first lambda expression";
	  
	   
	   meth obj =(s)-> s.replaceAll("[AEIOUaeiou]", "#");
	   
	   String newstr = obj.replace(str);
//	   System.out.println(obj.replace(str));
	   System.out.println(newstr);
}
}
