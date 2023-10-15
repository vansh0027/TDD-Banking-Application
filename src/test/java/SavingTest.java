import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingTest {
	public static final Integer ID = 12345678;
	public static final double AMOUNT = 100.00;
	public static final double SUM = 10.00;
	public static final double APR = 0.6;
	Account savings;

	@BeforeEach
	void setUp() {
		savings = new Savings(AMOUNT, APR);
		Bank.create(ID, savings);
	}

	@Test
	void default_amount_is_zero() {
		assertEquals(0, savings.amount);
	}

	@Test
	void apr_is_same_as_provided_value() {
		assertEquals(APR, savings.APR);

	}

	@Test
	void deposit_in_account() {
		savings.deposit(ID, AMOUNT);
		assertEquals((AMOUNT), savings.getAmount(ID));
	}

	@Test
	void double_deposit_in_account() {
		savings.deposit(ID, AMOUNT);
		savings.deposit(ID, AMOUNT);
		assertEquals((2 * AMOUNT), savings.getAmount(ID));
	}

	@Test
	void withdraw_from_account() {
		savings.deposit(ID, AMOUNT);
		savings.withdraw(ID, SUM);
		assertEquals((90), savings.getAmount(ID));

	}

	@Test
	void double_withdraw_from_account() {
		savings.deposit(ID, AMOUNT);
		savings.withdraw(ID, SUM);
		savings.withdraw(ID, SUM);
		assertEquals((80), savings.getAmount(ID));

	}

	@Test
	void account_amount_cannot_be_negative() {
		savings.withdraw(ID, AMOUNT);
		assertEquals(0, savings.getAmount(ID));
	}

}
