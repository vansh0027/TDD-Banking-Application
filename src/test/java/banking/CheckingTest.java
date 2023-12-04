package banking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingTest {
	public static final Integer ID = 12345678;
	public static final String ACCOUNT_TYPE = "checking";
	public static final double AMOUNT = 100.00;
	public static final double SUM = 10.00;
	public static final double APR = 0.6;
	Account checking;

	@BeforeEach
	void setUp() {
		checking = new Checking(AMOUNT, APR);
		Bank.create(ID, checking);
	}

	@Test
	void default_amount_is_zero() {
		assertEquals(0, checking.amount);
	}

}
