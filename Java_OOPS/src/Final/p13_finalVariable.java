package Final;
 
// final variable

class Area{
	//final variable
	final float pi = 3.14f;

}
class Circle extends Area{
	public void area(int r) {
	float ans = pi*r*r;
	System.out.println("The area of circle is - " + ans);
	}
}


public class p13_finalVariable {
  public static void main(String[] args) {
	Circle c  =new Circle();
	c.area(7);
}
}
