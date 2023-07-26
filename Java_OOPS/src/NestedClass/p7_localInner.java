package NestedClass;

// A class i.e., created inside a method, is called local inner class in java

class Outer{
	public void show() {
		class Inner{
			public void display() {
				int data = 12;
			    System.out.println("Hello!!! Im inner class inside the method of outer class");
			    System.out.println("My value is = " + data);
			   }
		}
		Inner in = new Inner();
		in.display();
	}
}

public class p7_localInner {
  public static void main(String[] args) {
     Outer o = new Outer();
     o.show();
}
}
