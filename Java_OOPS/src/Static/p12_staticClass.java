package Static;

class P{
	static String s = "Heyy....";
	
	String str = "Hello!!";
	
	static class Q{
		public void print() {
			System.out.println( s + "This is the static class....");
			
		// inner static class cannot access the outer class non static variables	
		//	System.out.println( str + "This is the static class....");
		}
	}
}
public class p12_staticClass {
  public static void main(String[] args) {
	P.Q pq = new P.Q();
	pq.print();
}
}
