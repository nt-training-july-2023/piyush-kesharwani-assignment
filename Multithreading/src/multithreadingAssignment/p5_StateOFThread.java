package multithreadingAssignment;

class Sthread extends Thread{
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("State of  " +Thread.currentThread().getName() +" is "+ Thread.currentThread().getState());
		
	}
}

class Sthread2 extends Thread{
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("State of  " +Thread.currentThread().getName() +" is "+ Thread.currentThread().getState());
		
	}
}

public class p5_StateOFThread {
	public static void main(String[] args) throws InterruptedException {
		Sthread s1 = new Sthread();
		System.out.println("State of  " +s1.getName() +" is "+ s1.getState());
		s1.start();
		System.out.println("State of  " +s1.getName() +" is "+ s1.getState());
		Sthread2 s2 = new Sthread2();
		System.out.println("State of  " +s2.getName() +" is "+ s2.getState());
		s2.start();
		s1.sleep(500);
		
		 try {
	            // waiting for thread2 to die
	            s1.join();
	        }
	        catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 
		 System.out.println("State of  " +s2.getName() +" is "+ s2.getState());
		 System.out.println("State of  " +s1.getName() +" is "+ s1.getState());
		 s2.join();
		 System.out.println("State of  " +s2.getName() +" is "+ s2.getState());
	}

}
