package Static;

class X{
	static String s = "This is static variables";
	
	// static block
	static{
		System.out.println("This is the static block");
	}
	
//	static {
//		System.out.println("We can create multiple static block inside a class");
//	}
}

public class p10_staticBlock {
 public static void main(String[] args) {
	 
	 X x = new X();
	 System.out.println(X.s);
}
}
