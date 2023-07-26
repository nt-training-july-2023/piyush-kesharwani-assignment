package Final;

// Final class

// final class cannot be inherited 

final class Mydetails{
	
	String s = "Hello !!!! ";
	 void print() {
		 System.out.println("This is my final class..");
	 }
}

public class p15_finalClass {
  public static void main(String[] args) {
	Mydetails m = new Mydetails();
	System.out.println(m.s);
	m.print();
}
}
