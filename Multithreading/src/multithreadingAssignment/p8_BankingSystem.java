package multithreadingAssignment;

class Banking{
	int amt;
	Banking(int amt){
		this.amt=amt;
	}
	public int getamt() {
		return amt;
	}
	public void getDeposit(int dep) {
	   amt = amt+dep;
		System.out.println("After deposit , your total amount is - "+ amt);	
	}
	
	public void withdrawl(int w) {
		amt = amt-w;
		System.out.println("After withdrawl, your total amount is - "+ amt);
	}
}

class Deposit extends Thread{
	Banking bb;
	int deposit;
	Deposit(Banking bb,int deposit){
		this.bb = bb;
		this.deposit = deposit;
	}
	
	public void run() {
		bb.getDeposit(deposit);
	
	}
}

class withdr extends Thread{
	Banking bb;
	int wd;
	withdr(Banking bb,int wd){
		this.bb = bb;
		this.wd = wd;
	}
	
	public void run() {
		bb.withdrawl(wd);
	}
}

public class p8_BankingSystem {
	public static void main(String[] args) {
		Banking b = new Banking(5000);
		System.out.println("Your currrent amount is - "+ b.getamt());
		Deposit d = new Deposit(b,1200);
		withdr ww = new withdr(b,1500);
		d.start();
		ww.start();
	}

}
