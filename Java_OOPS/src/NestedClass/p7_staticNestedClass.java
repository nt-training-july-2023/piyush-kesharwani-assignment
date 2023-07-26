package NestedClass;

// A static class is a class that is created inside a class, is called a static nested class in Java.
// It cannot access non-static data members and methods

class Outer1{
	static int data = 22;
	static class Inner1{
		public void display() {
			System.out.println("This is static inner classs ..");
			System.out.println("the value of varaible is - "+ data);
		}
	}
}

public class p7_staticNestedClass {
  public static void main(String[] args) {
	Outer1.Inner1 innn = new Outer1.Inner1();
	innn.display();
}
}
