package multithreadingAssignment;

class A extends Thread{
	
	public void run() {
		int i=0;
		while(i<100) {
			System.out.println("thread A is executing");
			i=i+2;
		}
	}
	
}

class B extends Thread{
	public void run() {
		int i=0;
		while(i<100) {
			System.out.println("thread B is executing");
			i=i+2;
		}
	}
}

class C extends Thread{
	public void run() {
		int i=0;
		while(i<50) {
			System.out.println("Thread C is executing");
			i++;
		}
	}
}

public class p2_runningThread {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		
		a.start();
		b.start();
		c.start();
	}

}
