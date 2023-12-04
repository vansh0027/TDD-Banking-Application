package banking;

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

}
