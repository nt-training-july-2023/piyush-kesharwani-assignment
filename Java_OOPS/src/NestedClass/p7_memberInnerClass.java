package NestedClass;

//A non-static class that is created inside a class but outside a method is called member inner class.


public class p7_memberInnerClass {
	
	private String s = "hey!! I am an outer class";
	
	class Inner{
		String str = "Hey!!! I am an inner class";
		
		public void display() {
			System.out.println("Displaying outer class string - " + s);
			System.out.println("displaying inner class string - " + str);
		}
	}
	
	public static void main(String[] args) {
		p7_memberInnerClass mi = new p7_memberInnerClass();
		p7_memberInnerClass.Inner inn = mi.new Inner();
		
		inn.display();
	}

}
