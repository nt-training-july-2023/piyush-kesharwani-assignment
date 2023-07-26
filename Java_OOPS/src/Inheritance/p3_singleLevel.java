package Inheritance;

// Inheritance - Inheritance in Java is a mechanism in which one object acquires 
//               all the properties and behaviors of a parent object

// Single Level Inheritance

class calc{
	int c;
	public void sum(int a,int b) {
		c = a+b;
		System.out.println("the sum of a and b - " + c);
	}
}

class sub extends calc{
	public void subtraction(int a ,int b) {
		c = a-b;
		System.out.println("Subatraction of a and b = "+ c);
	}
}


public class p3_singleLevel {
  public static void main(String[] args) {
	  sub s = new sub();
	  int a = 22,b =3;
	  
	  s.sum(a, b);
	  s.subtraction(a, b);
	
}
}
