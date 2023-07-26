package Final;

class Area1{
	//final variable
	final float pi = 3.14f;
	final int radius;  // blank final Variable
	
	// blank final can only be initialize in constructor
	Area1(){
		radius = 9;
	}
	
	public void result() {
		float ans = pi*radius*radius;
		System.out.println("this is the example of blank final ");
		System.out.println("the area is = " + ans);
	}

}

public class p14_BlankFinal {
	public static void main(String[] args) {
		Area1 a1 = new Area1();
		a1.result();
		
		
	}

}
