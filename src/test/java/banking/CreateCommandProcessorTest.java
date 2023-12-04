package banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateCommandProcessorTest {
	public final Integer ID = 12345678;
	Bank bank;

	@BeforeEach
	void setUp() {
		bank = new Bank();
	}

	@Test
	void checking_account_is_created_as_specified() {
		CommandProcessor.create("create checking 12345678 1.0");
		assertTrue(Bank.bank.containsKey(ID));
		assertTrue(Bank.bank.get(ID) instanceof Checking);

		assertEquals(1.0, ((Account) bank.getId(ID)).getAPR(ID));

	}

	@Test
	void savings_account_is_created_as_specified() {
		CommandProcessor.create("create savings 12345678 1.0");
		assertTrue(Bank.bank.containsKey(ID));
		assertTrue(Bank.bank.get(ID) instanceof Savings);
		assertEquals(1.0, ((Account) bank.getId(ID)).getAPR(ID));

	}

	@Test
	void CD_account_is_created_as_specified() {
		CommandProcessor.create("create banking.CD 12345678 9 2000");
		assertTrue(Bank.bank.containsKey(ID));
		assertTrue(Bank.bank.get(ID) instanceof CD);
		assertEquals(9, ((Account) bank.getId(ID)).getAPR(ID));
		assertEquals(2000, ((Account) bank.getId(ID)).getAmount(ID));

	}

	@Test
	void money_is_deposited_into_new_bank_account() {
		CommandProcessor.create("create checking 12345678 1.0");
		CommandProcessor.deposit("deposit 12345678 100");
		assertEquals(100.00, ((Account) bank.getId(ID)).getAmount(ID));
	}

	@Test
	void money_is_deposited_into_old_bank_account() {
		CommandProcessor.create("create checking 12345678 1.0");
		CommandProcessor.deposit("deposit 12345678 100");
		CommandProcessor.deposit("deposit 12345678 100");
		assertEquals(200.00, ((Account) bank.getId(ID)).getAmount(ID));
	}

}
