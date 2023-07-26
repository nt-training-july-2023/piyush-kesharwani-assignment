package Inheritance;

// multiple inheritance can be achieved by the interface

interface car{
	void wheels();
}

interface bike{
	void disc();
}

// Tyre implements both interface at once

class Tyre implements car,bike{
	public void wheels() {
		System.out.println("The car have 4 wheels");
	}
	
	public void disc() {
		System.out.println("The bike have 2 disc");
	}
	
}

public class p4_multipleInheritance {
	public static void main(String[] args) {
		Tyre t = new Tyre();
		t.disc();
		t.wheels();
	}

}
