package multithreadingAssignment;

class message extends Thread{
   message(String s){
	   super(s);
   }
   
   public void run() {
	   int i=0;
	   while(i<5) {
		   System.out.println(Thread.currentThread().getName() + " reading the message ");
		   i=i+2;
	   }
   }
}


public class p4_readingMessage {
	public static void main(String[] args) {
		message m = new message("Hello");
		Thread t1 = new Thread(m);
		t1.setName("Raj");
	
		Thread t2 = new Thread(m);
		t2.setName("Simran");
		
		Thread t3 = new Thread(m);
		t3.setName("Salman");	
		
		t1.start();
		t2.start();
		t3.start();
	}

}
