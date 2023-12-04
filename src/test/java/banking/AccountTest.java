package banking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

	public static final Integer ID = 12345678;
	public static final String ACCOUNT_TYPE = "banking.CD";
	public static final double AMOUNT = 100.00;
	public static final double SUM = 10.00;
	public static final double APR = 0.6;
	public static final int ID2 = 12345679;
	public static final int ID3 = 12345677;
	Account checking;
	Account savings;
	Account cd;

	@BeforeEach
	void setUp() {
		checking = new Checking(AMOUNT, APR);
		savings = new Savings(AMOUNT, APR);
		cd = new CD(AMOUNT, APR);

		Bank.create(ID, cd);
		Bank.create(ID2, savings);
		Bank.create(ID3, checking);
	}

	@Test
	void apr_is_same_as_provided_value() {
		assertEquals(APR, savings.APR);
		assertEquals(APR, checking.APR);
		assertEquals(APR, savings.APR);

	}

	@Test
	void deposit_in_account() {
		savings.deposit(ID2, AMOUNT);
		checking.deposit(ID3, AMOUNT);
		cd.deposit(ID, AMOUNT);
		assertEquals((AMOUNT), savings.getAmount(ID2));
		assertEquals(AMOUNT, checking.getAmount(ID3));
		assertEquals(2 * AMOUNT, cd.getAmount(ID));
	}

	@Test
	void double_deposit_in_account() {
		savings.deposit(ID2, AMOUNT);
		checking.deposit(ID3, AMOUNT);
		cd.deposit(ID, AMOUNT);
		savings.deposit(ID2, AMOUNT);
		checking.deposit(ID3, AMOUNT);
		cd.deposit(ID, AMOUNT);
		assertEquals((2 * AMOUNT), savings.getAmount(ID2));
		assertEquals(2 * AMOUNT, checking.getAmount(ID3));
		assertEquals(3 * AMOUNT, cd.getAmount(ID));

	}

	@Test
	void withdraw_from_account() {
		savings.deposit(ID2, AMOUNT);
		checking.deposit(ID3, AMOUNT);
		cd.deposit(ID, AMOUNT);
		savings.withdraw(ID2, SUM);
		checking.withdraw(ID3, SUM);
		cd.withdraw(ID, SUM);

		assertEquals(90, savings.getAmount(ID2));
		assertEquals(90, checking.getAmount(ID3));
		assertEquals(190, cd.getAmount(ID));

	}

	@Test
	void double_withdraw_from_account() {
		savings.deposit(ID2, AMOUNT);
		checking.deposit(ID3, AMOUNT);
		cd.deposit(ID, AMOUNT);
		savings.withdraw(ID2, SUM);
		checking.withdraw(ID3, SUM);
		cd.withdraw(ID, SUM);
		savings.withdraw(ID2, SUM);
		checking.withdraw(ID3, SUM);
		cd.withdraw(ID, SUM);

		assertEquals(80, savings.getAmount(ID2));
		assertEquals(80, checking.getAmount(ID3));
		assertEquals(180, cd.getAmount(ID));
	}

	@Test
	void account_amount_cannot_be_negative() {

		savings.withdraw(ID2, AMOUNT);
		checking.withdraw(ID3, AMOUNT);
		cd.withdraw(ID, 2 * AMOUNT);
		assertEquals(0, savings.getAmount(ID2));
		assertEquals(0, checking.getAmount(ID3));
		assertEquals(0, cd.getAmount(ID));
	}
}
