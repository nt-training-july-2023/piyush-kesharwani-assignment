package Polymorphism;

class division{
	public int div(int a,int b) {
		return a/b;
	}
	
	// overloading a method div
	
	public double div(double a , double b) {
		return  a/b;
	}
}

public class p2_method_overloading {
   public static void main(String[] args) {
	   
	   division d = new division();
	   System.out.println("division of a/b is " + d.div(42, 2));
	   System.out.println("division of a/b is " + d.div(13, 2));
	   
	   System.out.println("division of a/b - " + d.div(23.1, 2.1));
	
}
}
