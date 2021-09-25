package banktests;

import banksystem.SavingAccount;

import java.util.Date;

import org.junit.*;
import static org.junit.Assert.*;    
import org.junit.Test;
public class SavingAccountTest {
	private static SavingAccount SA;
	@BeforeClass
	public static void init() {
		SA=new SavingAccount();	
		SA.Add(1234, "Sameet", 111, "chakwal", 5000);
		
	}
	@Test
	public void PositiveTest() {
		assertEquals(1,SA.Add(2341, "Sameet", 111, "chakwal", 5000));
		assertEquals(4500,SA.MakeWithdrawel(1234, 500));
		SA.Add(1111, "Hadia", 123456, "Islamabad", 30000);
		assertEquals(1,SA.Zakat(1111));
		assertEquals(1,SA.CalculateInterest(1111));
		assertEquals(1,SA.check(1111));
		assertEquals(0,SA.check(4444));
		assertEquals(1,SA.remove(1111));
		assertEquals(5500,SA.MakeDeposit(1234,1000));
		assertEquals(1,SA.PrintStatement(1234));
		assertEquals(7500,SA.Transfer(2341,11111,2000));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void NegativeTest() {
		SA.Add(1234, "Ikram", 1234, "chakwal", 25823);
		SA.MakeWithdrawel(1234, 50000);
		SA.Zakat(1234);
		SA.remove(3333);
		SA.MakeDeposit(6666, 20000);
		SA.PrintStatement(6666);
		SA.Transfer(2341, 12334, 100);
		SA.Transfer(3452, 11111, 100);
		SA.Transfer(2341, 11111, 500000);
	}
	

}
