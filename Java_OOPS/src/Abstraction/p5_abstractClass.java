package Abstraction;

// Abstraction - it is a process of hiding the implementation details 
//               and showing only functionality to the user.

abstract class Stock{
	abstract void buy();
	abstract void sell();
}

class Person extends Stock{
   void buy() {
	   System.out.println("The Person is buying the stocks");
   }
   void sell() {
	   System.out.println("and Selling the stocks with good profit...");
   }
}

public class p5_abstractClass {
	
	public static void main(String[] args) {
		Stock p = new Person();
		p.buy();
		p.sell();
	}

}
