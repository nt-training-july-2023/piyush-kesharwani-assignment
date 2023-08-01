package multithreadingAssignment;

import java.util.Scanner;

class Sum extends Thread{
	int n;
	Sum(int n){
		this.n=n;
	}
	public void run() {
		int sum=0;
		
		for(int i=0;i<n;i++) {
			sum += i;
		}
		
		System.out.println("the sum of first n number is - " + sum);
	}
}

class fibo extends Thread{
	int n;
	fibo(int n){
		this.n=n;
	}
	public synchronized void run() {
		int a=0;
		int b=1;
		int c=0;
		System.out.print("fibonacci series is - " + a+ " "+ b +" ");
		for(int i=2;i<n;i++) {
			c = a+b;
			a=b;
			b=c;
			System.out.print(c+ " ");
			
		}
		System.out.println();
	}
}
	
class reve extends Thread{
	int n;
	reve(int n){
		this.n=n;
	}
	public void run() {
		System.out.print("the reverse of first n number is - " );
		for(int i=n;i>0;i--) {
			System.out.print(i+ " ");
		}
		System.out.println();
	}
}


public class p3_performingTask {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number that you want to perform task -");
		int num = sc.nextInt();
		
		Sum s = new Sum(num);
		fibo f = new fibo(num);
		reve r = new reve(num);
		
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(f);
		Thread t3 = new Thread(r);
		t1.start();
		//t1.join();
		t2.start();
		t2.setPriority(10);
		//t2.join();
		t3.start();
		
		
		
	}

}
