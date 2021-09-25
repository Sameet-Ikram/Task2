package banksystem;
public class SavingAccount extends AccountClass{
	AccountClass AC=new AccountClass();
	float interest_rate=.20f;
	public int MakeWithdrawel(int x, int value) {
		
		int ind=pin.indexOf(x);
		int amount=balance.get(ind);
		if(amount<value)
		{
			throw new IllegalArgumentException("Sorry you don't have enoungh balance in your account");
		}
		else {
			amount=amount-value;
			balance.set(ind, amount);
		}
		return balance.get(ind);
		
	}
	
	public int Zakat(int pinn) {
		int ind1=pin.indexOf(pinn);
		int bal=balance.get(ind1);
		if(bal>20000)
		{
			double zakat=(bal*2.5)/100;
			System.out.println("The zakat on your account is: "+zakat);
			return 1;
		}
		else {
			throw new IllegalArgumentException("Zakat is not applicable on your account");
			
		}
	}
	
	public int CalculateInterest(int pinn) {
		
		
		int ind1=pin.indexOf(pinn);
		int bal=balance.get(ind1);
		float interest=(bal*interest_rate);
		System.out.println("The Interest on your account is: "+interest);
		return 1;
	}

}
