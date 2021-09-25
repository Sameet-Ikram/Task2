
package banksystem;
import java.util.*;
//import java.text.SimpleDateFormat;  
//import java.util.Date;
//import java.util.Scanner;
public class MainClass {

	public static void main(String[] args) {
		//MENU
		int flag=5;
		SavingAccount SA=new SavingAccount();
		CheckingAccount CA=new CheckingAccount();
		Scanner sc= new Scanner(System.in);
		while(flag!=0)
		{
		
			System.out.println("Please select the service that you want to get:");
			System.out.println("1. Open an account");
			System.out.println("2. Close an account");
			System.out.println("3. Log in to an account");
			//AccountClass AC=new AccountClass();
			int choice=sc.nextInt();
			if(choice==1)
			{
				System.out.println("Hi! Thank You for choosing our Bank.Please specify the type of account that you want to open:");
				System.out.println("1. Saving Account");
				System.out.println("2. Checking Account");
				int type=sc.nextInt();
				if(type==1)
				{
					System.out.println("Please Enter your Pin code");
					int pin=sc.nextInt();
					if(SA.check(pin)==1) {
						System.out.println("A user can have only one saving account");
						
					}
					else if(SA.check(pin)==0){
						sc.nextLine();
						System.out.println("Please Enter your name:");
						String name=sc.nextLine();
						System.out.println("Please Enter your phone no:");
						int phone=sc.nextInt();
						sc.nextLine();
						System.out.println("Please Enter your address:");
						String address=sc.nextLine();
						sc.nextLine();
						System.out.println("Please deposit strating balance in your account");
						int balance=sc.nextInt();
						
						SA.Add(pin,name,phone,address,balance);
						
						
					}
				}	
				else if(type==2) {
					
					System.out.println("Please Enter your Pin code");
					int pin=sc.nextInt();
					if(CA.check(pin)==1) {
						System.out.println("A user can have only one checking account");
						
					}
					else if(CA.check(pin)==0){
						sc.nextLine();
						System.out.println("Please Enter your name:");
						String name=sc.nextLine();
						System.out.println("Please Enter your phone no:");
						int phone=sc.nextInt();
						sc.nextLine();
						System.out.println("Please Enter your address:");
						String address=sc.nextLine();
						System.out.println("Please deposit starting balance in your account");
						int balance=sc.nextInt();
						CA.Add(pin,name,phone,address,balance);
						
						
					}
				
				}	
			}
			
			else if(choice==2) {
			
				System.out.println("Please enter your unique pin number of the account you want to close.");
				int pin=sc.nextInt();
				System.out.println("Please specify the account type you want to close");
				System.out.println("1. Savings");
				System.out.println("2. Checkings");
				int opt=sc.nextInt();
				if(opt==1) {
					
					if(SA.check(pin)==1) {
						
						SA.remove(pin);
					}
					else if(SA.check(pin)==0) {
						
						System.out.println("You have entered wrong pin. Their is no such saving account with this pin");
					}
				}
				else if(opt==2) {
					if(CA.check(pin)==1) {	
						CA.remove(pin);
					}
					else if(CA.check(pin)==0) {
						
						System.out.println("You have entered wrong pin. Their is no such checking account with this pin");
					}
					
				}
				else {
					
					System.out.println("Sorry wrong option selected");
					
				}
			
			}
			else if(choice==3) {
				System.out.println("Please enter your unique pin number to log in to your account:");
				int pin=sc.nextInt();
				System.out.println("Please specify the account type you want to log in:");
				System.out.println("1. Savings");
				System.out.println("2. Checkings");
				int type=sc.nextInt();
				if(type==1) {
					
					if(SA.check(pin)==1) {	
						//System.out.println("");
						System.out.println("Please select from the following options:");
						System.out.println("1. Check Balance");
						System.out.println("2. Make Deposit");
						System.out.println("3. Make Withdrawel");
						System.out.println("4. Print statement");
						System.out.println("5. Transfer Amount");
						System.out.println("6. Calculate Zakat");
						System.out.println("7. Calculate interest");
						int opt=sc.nextInt();
						if(opt==1) {
							
							SA.checkbalance(pin);
						}
						else if(opt==2) {
							System.out.println("Please specify the amount you want to deposit:");
							int amount=sc.nextInt();
							SA.MakeDeposit(pin,amount);
						}
						else if(opt==3) {
							System.out.println("Please specify the amount you want to Withdraw:");
							int amount=sc.nextInt();
							SA.MakeWithdrawel(pin,amount);
							
						}
						else if(opt==4) {
							
							SA.PrintStatement(pin);
							
						}
						else if(opt==5) {
							System.out.println("Enter the account number of the account you want to transfer money:");
							int acc=sc.nextInt();
							System.out.println("Enter the amount you want to transfer: ");
							int amount=sc.nextInt();
							SA.Transfer(pin,acc,amount);
							
							
						}
						else if(opt==6) {
							
							//Calculate zakat
							SA.Zakat(pin);
							
							
						}
						
						else if(opt==7) {
							SA.CalculateInterest(pin);
							
						}
						else {
							
							
							System.out.println("Sorry you have entered wrong input");
						}
						//
					}
					else if(SA.check(pin)==0) {
						
						System.out.println("You have entered wrong pin. Their is no such saving account with this pin");
					}
				}
				if(type==2) {
					if(CA.transaction_no>2)
					{
						//this will deduct 10 rupees each time the customer will make a transaction
						int ind=CA.balance.indexOf(pin);
						int bal=CA.balance.get(ind);
						bal=bal-10;
						CA.balance.set(ind,bal );
					}
					if(CA.check(pin)==1) {	
						//Give options
						
						if(CA.check(pin)==1) {	
							//System.out.println("");
							System.out.println("Please select from the following options:");
							System.out.println("1. Check Balance");
							System.out.println("2. Make Deposit");
							System.out.println("3. Make Withdrawel");
							System.out.println("4. Print statement");
							System.out.println("5. Transfer Amount");
							System.out.println("6. Calculate Tax");
							//System.out.println("7. Calculate interest");
							int opt=sc.nextInt();
							if(opt==1) {
								
								CA.checkbalance(pin);
							}
							else if(opt==2) {
								System.out.println("Please specify the amount you want to deposit:");
								int amount=sc.nextInt();
								CA.MakeDeposit(pin,amount);
							}
							else if(opt==3) {
								System.out.println("Please specify the amount you want to Withdraw:");
								int amount=sc.nextInt();
								CA.MakeWithdrawel(pin,amount);
								
							}
							else if(opt==4) {
								
								CA.PrintStatement(pin);
								
							}
							else if(opt==5) {
								System.out.println("Enter the account number of the account you want to transfer money:");
								int acc=sc.nextInt();
								System.out.println("Enter the amount you want to transfer: ");
								int amount=sc.nextInt();
								CA.Transfer(pin,acc,amount);
								
								
							}
							else if(opt==6) {
								CA.Tax(pin);
								
								
							}
							
							else {
								
								
								System.out.println("Sorry you have entered wrong input");
							}
							//
						}
						else if(SA.check(pin)==0) {
							
							System.out.println("You have entered wrong pin. Their is no such saving account with this pin");
						}
						

						
					}
					else if(CA.check(pin)==0) {
						
						System.out.println("You have entered wrong pin. Their is no such checking account with this pin");
					}
					
				}	
			
			}
			else {
			
				System.out.println("Sorry!!! Wrong input");	
			
			}

			System.out.println("Press any key to continue...Enter 0 if you want to quit");
			flag=sc.nextInt();
		}

	}
}
