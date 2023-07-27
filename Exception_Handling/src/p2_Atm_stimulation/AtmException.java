package p2_Atm_stimulation;

import java.util.Scanner;

public class AtmException  {

  public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the account balance -> ");
       double amt = sc.nextDouble();
       System.out.println("Enter the withdrawl amount ->");
       double wid = sc.nextDouble();
       
       try {
        if(amt<0) {
        	throw new InvalidInputException("Enter valid amount....");
        }
        else if(wid>amt){
        	throw new InvalidInputException("Your Account balance is lower than withdrawl amount");
        }
        else {
        	System.out.println("Withdrawl is successfull....");
        	double ans = amt-wid;
        	System.out.println("Remaining balance is - " + ans);
        }
        
       }catch(InvalidInputException ex){
    	 System.out.println(ex.getMessage());
       }
       finally {
    	   System.out.println("System exit...");
       }
       
	}
}
