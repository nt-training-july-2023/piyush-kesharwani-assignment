package Final;

class ABC{
	
	final void method() {
		System.out.println("This is the final methods...");
	}
}

class XYz extends ABC{

	// we cannot override the final methods...
//	void method() {
//		System.out.println("Overriding the final method...");
//	}

}

public class p16_finalMethod {
  public static void main(String[] args) {
	ABC abc = new ABC();
	abc.method();
}
}
