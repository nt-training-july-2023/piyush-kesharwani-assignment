package operatorAndExpression;

public class problem4_incrementDecrementOperator {
	public static void main(String[] args) {
		int a = 10;
		System.out.println("The value of a-> " + a);
		
		int b = ++a;
		System.out.println("Pre Increment-");
		System.out.println("The value of b-> " + b);
		
		
		
		int c = a++;
		System.out.println("Post Increment");
		System.out.println("The value of c-> " + c);
		
		System.out.println("finally the value of a- "+ a);
		
		
		
	}

}
