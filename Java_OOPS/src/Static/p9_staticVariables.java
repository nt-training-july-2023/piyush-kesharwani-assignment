package Static;
  
class A{
	static int count=0;
	
	A(){
		count++;
		System.out.println(count);
	}
}
public class p9_staticVariables {
	public static void main(String[] args) {
      A a = new A();
      A a1= new A();
      A a3 = new A();
	}

}
