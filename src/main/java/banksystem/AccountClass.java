package banksystem;

import java.util.LinkedList;
import java.text.SimpleDateFormat;  
import java.util.Date;
public class AccountClass{
	//Node N=new Node();
	//private
	LinkedList<Integer> pin=new LinkedList<Integer>();
	LinkedList<String> name=new LinkedList<String>();
	LinkedList<Integer> phone=new LinkedList<Integer>();
	LinkedList<String> address=new LinkedList<String>();
	LinkedList<Integer> accountno=new LinkedList<Integer>();
	LinkedList<String> date=new LinkedList<String>();
	LinkedList<Integer> balance=new LinkedList<Integer>();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	//LinkedList<Node> data=new LinkedList<Node>();
	int transaction;
	
	static int AccNo=11111;
	//Access Modifiers
	//Getter Functions
	public int getpin(int x) {
		int p=pin.indexOf(x);
		return pin.get(p);	
	}
	public String getname(int x) {
		int s=name.indexOf(x);
		return name.get(s);	
	}
	public int getphone(int x) {
		int p=phone.indexOf(x);
		return phone.get(p);	
	}
	public String getaddress(int x) {
		int a=pin.indexOf(x);
		return address.get(a);	
	}
	public int getaccountno(int x) {
		int a=accountno.indexOf(x);
		return accountno.get(a);	
	}
	public String getDate(int x) {
		int d=date.indexOf(x);
		return date.get(d);	
	}
	public int getbalance(int x) {
		int b=balance.indexOf(x);
		return balance.get(b);	
	}
	
	//Setter Functions
	
	public void setpin(int x) {
		pin.add(x);	
	}
	public void setname(String x) {
		name.add(x);	
	}
	public void setphone(int x) {
		phone.add(x);	
	}
	public void setaddress(String x) {
		address.add(x);	
	}
	public void setaccountno(int x) {
		accountno.add(x);	
	}
	public void setDate(String x) {
		date.add(x);	
	}
	public void setbalance(int x) {
			balance.add(x);
	}
	
	
	
	public int Add(int a, String b, int c, String d, int g)
	{
		
		if(pin.indexOf(a)!=-1)
		{
		System.out.println("Throw statement executed");	
		throw new IllegalArgumentException("Sorry this pin already exists");	
		}
		else
		{
			
			Date datee=new Date();
			setpin(a);
			setname(b);
			setphone(c);
			setaddress(d);
			setaccountno(AccNo);
			String DATE=formatter.format(datee);
			setDate(DATE);
			setbalance(g);
			AccNo++;
		}
		return 1;
		
	}
	public int check(int x) {
		
			if(pin.indexOf(x)!=-1) {
				return (1);
			
			}
			else {
				return (0);
			}
		}
	public int remove(int x) {
		if(pin.indexOf(x)!=-1)
		{
			int ind=pin.indexOf(x);
			pin.remove(ind);
			name.remove(ind);
			phone.remove(ind);
			address.remove(ind);
			accountno.remove(ind);
			date.remove(ind);
			balance.remove(ind);
			return 1;
		}
		else
			throw new IllegalArgumentException("This type of account doen't exists");
	}
	
	public int checkbalance(int x) {
		int ind=pin.indexOf(x);
		System.out.println("Balance in your account is: "+balance.get(ind));
		return getbalance(x);
	}
	
	
	public int MakeDeposit(int x,int value) {
	if((pin.indexOf(x)!=-1))
		{	
			int ind=pin.indexOf(x);
			int amount=balance.get(ind);
			amount=amount+value;
			balance.set(ind, amount);
			transaction=value;
			int v=balance.get(ind);
			return v;
		}
	else
		throw new IllegalArgumentException("This type of account doen't exists");
	}
	public int PrintStatement(int x) {
		if((pin.indexOf(x)!=-1))
		{
			int ind=pin.indexOf(x);
			System.out.println("Name: "+name.get(ind));
			System.out.println("Phone No: "+phone.get(ind));
			System.out.println("Address: "+address.get(ind));
			System.out.println("Account No: "+accountno.get(ind));
			System.out.println("Transaction date: "+date);
			System.out.println("Transaction amount: "+transaction);
			System.out.println("Remaining balance: "+balance.get(ind));
			return 1;
		}
		else
			throw new IllegalArgumentException("This type of account doen't exists");
	}

		
	public int Transfer(int pin1,int acc, int amountt) {
		if(pin.indexOf(pin1)!=-1)
		{
			if(accountno.indexOf(acc)!=-1) {
				int ind1=pin.indexOf(pin1);
				int ind2=accountno.indexOf(acc);
				int balancee=balance.get(ind1);//gets balance of account 1
				if(amountt>balancee)
				{
					
					System.out.println("Sorry you don't have enough balance to transfer amount");
					throw new IllegalArgumentException("");
				}
				else
				{
					balancee=balancee-amountt;
					balance.set(ind1, balancee);
					int balance2=balance.get(ind2);
					balance2=balance2+amountt;
					balance.set(ind2, balance2);
					return balance2;
					
				}
			
			}
			else {
				
				
				System.out.println("Sorry the account you want to transfer money doesn't exist.");
				throw new IllegalArgumentException("");
			}
		
		}
		else
			throw new IllegalArgumentException("The account from where you want to transfer money doesn't exist");
		
		//return 1;
	}
	
	

}
