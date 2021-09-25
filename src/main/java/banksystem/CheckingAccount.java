package banksystem;

public class CheckingAccount extends AccountClass{
	AccountClass AC=new AccountClass();
	double taxx=2.5;
	int transaction_no=0;
	int transaction_fee=10;
	
public int MakeWithdrawel(int x, int value) {
		
		if(pin.indexOf(x)!=-1)
		{
			int ind=pin.indexOf(x);
			int amount=balance.get(ind);
			int checking=amount+5000; //since in checking account we can withdraw more than the balance and the limit is 5000.
			if(checking<value)
			{
				System.out.println("Sorry you don't have enough balance");
				throw new IllegalArgumentException("");
			}
			else {
				
				amount=amount-value;
				balance.set(ind, amount);
				return amount;
			}
		}
		else
			throw new IllegalArgumentException("Sorry this pin doesn't exists");
	}
public int Tax(int p) {
	if(pin.indexOf(p)!=-1) 
	{
		int ind1=pin.indexOf(p);
		int bal=balance.get(ind1);
		double tax=(bal*(taxx/100));
		System.out.println("The Tax on your account is: "+tax);
		return 1;
	}
	else
		throw new IllegalArgumentException("Sorry this pin doesn't exists");
	
	
}
}
