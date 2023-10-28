import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CDAccountsTest {
	public static final Integer ID = 12345678;
	public static final String ACCOUNT_TYPE = "CD";
	public static final double AMOUNT = 100.00;
	public static final double SUM = 10.00;
	public static final double APR = 0.6;
	Account cd;

	@BeforeEach
	void setUp() {
		cd = new CD(AMOUNT, APR);
		Bank.create(ID, cd);
	}

	@Test
	void amount_is_same_as_provided() {
		assertEquals(AMOUNT, cd.amount);
	}

	@Test
	void create_an_account() {
		assertEquals(AMOUNT, cd.getAmount(ID));
	}
}
