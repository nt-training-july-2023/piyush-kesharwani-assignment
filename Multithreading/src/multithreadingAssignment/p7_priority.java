package multithreadingAssignment;

class thPriority extends Thread{
   public void run() {
	   int i=0;
	   while(i<20) {
		   System.out.println("I am thread 1 ");
		   i++;
	   }
   }
}

class thPriority2 extends Thread{
	   public void run() {
		   int i=0;
		   while(i<20) {
			   System.out.println("I am thread 2 ");
			   i++;
		   }
	   }
	}

class thPriority3 extends Thread{
	   public void run() {
		   int i=0;
		   while(i<20) {
			   System.out.println("I am thread 3 with highest priority  ");
			   i++;
		   }
	   }
	}

public class p7_priority {
	public static void main(String[] args) {
		thPriority t1 = new thPriority();
		thPriority2 t2 = new thPriority2();
		thPriority3 t3 = new thPriority3();
	
		// setting up the priority of the thread
		t3.setPriority(Thread.MAX_PRIORITY);
		//t1.setPriority(Thread.NORM_PRIORITY);
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		
//		System.out.println("Priority of thread 1 - " +t1.getPriority());
//		System.out.println("Priority of thread 2 - " +t2.getPriority());
//		System.out.println("Priority of thread 3 - " + t3.getPriority());
	}

}
