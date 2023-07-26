package Polymorphism;

class Basecar{
	public int topSpeed() {
		return 120;
	}
}

// creating child class
class Maserati extends Basecar{
	
	// method overriding
	public int topSpeed() {
		return 203;
	}
}

class Porsche extends Basecar{
	
	public int topSpeed() {
		return 198;
	}
}

public class p2_method_overriding {
  public static void main(String[] args) {
	Maserati m = new Maserati();
	Porsche p = new Porsche();
	
	System.out.println("The top speed of Maserati is - " + m.topSpeed() + " km/hr");
	System.out.println("The top speed of Porsche is - " + p.topSpeed() + " km/hr");
}
}
