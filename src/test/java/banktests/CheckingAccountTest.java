package banktests;

import banksystem.CheckingAccount;
import banksystem.SavingAccount;

import java.util.Date;

import org.junit.*;
import static org.junit.Assert.*;

public class CheckingAccountTest {

	private static CheckingAccount CA;
	@BeforeClass
	public static void init() {
		CA=new CheckingAccount();	
		CA.Add(1234, "Sameet", 111, "chakwal", 5000);
		
	}
	
	@Test
	public void PositiveTest() {
		assertEquals(1,CA.Add(2341, "Sameet", 111, "chakwal", 5000));
		assertEquals(4500,CA.MakeWithdrawel(1234, 500));
		CA.Add(1111, "Hadia", 123456, "Islamabad", 30000);
		assertEquals(1,CA.check(1111));
		assertEquals(0,CA.check(4444));
		assertEquals(1,CA.remove(1111));
		assertEquals(5500,CA.MakeDeposit(1234,1000));
		assertEquals(1,CA.PrintStatement(1234));
		assertEquals(7500,CA.Transfer(2341,11111,2000));
		assertEquals(1,CA.Tax(1234));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void NegativeTest() {
		CA.Add(1234, "Ikram", 1234, "chakwal", 25823);
		CA.MakeWithdrawel(1234, 50000);
		CA.remove(3333);
		CA.MakeDeposit(6666, 20000);
		CA.PrintStatement(6666);
		CA.Transfer(2341, 12334, 100);
		CA.Transfer(3452, 11111, 100);
		CA.Transfer(2341, 11111, 500000);
		CA.Tax(3333);
	}

}
