package Static;

class Multiply{
	static int n=5;
	int data=12;
	 
	static void printNumber() {
		System.out.println("the value of n is - "+ n);
		System.out.println("The number between 0 to n is ");
		for(int i=0;i<n;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	// changing values of n
	 void changeValue() {
		 // changing the value of static variables
		 n = 6;
		 System.out.println("the value of n is now - " + n);
		 
		 // changing thE value of non static variables
		 data =14;
	 }
}

public class p11_staticMethods {
   public static void main(String[] args) {
	 Multiply m = new Multiply();
	 Multiply.printNumber();
	 m.changeValue();
	 System.out.println("The data is = " + m.data);
}
}
