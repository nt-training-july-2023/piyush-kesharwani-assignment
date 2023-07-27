package p10_invalidPassword;

import java.util.Scanner;

public class createPassword {
	
	public static void checkpass(String ans) throws InvalidPasswordException {
		String num = ".*[0-9].*";
		String alp = ".*[a-z].*";
		String capalpha = ".*[A-Z].*";
		
		if(ans.length()<8) {
			throw new InvalidPasswordException("length is too small ..its should of atleast 8 character...");
			
		}
		if(!(ans.matches(num) && ans.matches(capalpha) || ans.matches(alp))) {
			throw new InvalidPasswordException("Invalid password...");
		}
		System.out.println("Your password is- " + ans);
	}
	
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
     System.out.println("Create your password....");
     System.out.println("Enter your password (it should be atleast 8 character.. ");
         try {
        	 String ans = sc.nextLine();
        	 checkpass(ans);
         }
         catch(InvalidPasswordException e) {
        	 System.out.println(e);
         }
     
     }


}
