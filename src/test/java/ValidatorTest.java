import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
	public static final String ACCOUNT_TYPE = "checking";
	public static final double AMOUNT = 100.00;
	public static final double SUM = 10.00;
	public static final double APR = 0.6;
	Validator validator;
	Account account = new Checking((double) 0, APR);
	Account savings = new Savings((double) 0, APR);
	Account cd = new CD(AMOUNT, APR);

	@Test
	void deleted_id_can_be_reused() {
		Bank bank = new Bank();
		bank.create(12345670, account);
		bank.create(12345671, savings);
		bank.create(12345672, cd);
		bank.remove(12345670);
		bank.remove(12345671);
		bank.remove(12345672);
		assertTrue(validator.idIsUnique("create checking 12345670 9"));
		assertTrue(validator.idIsUnique("create savings 12345671 9"));
		assertTrue(validator.idIsUnique("create CD 12345672 9 1000"));

	}

	@Test
	void account_type_is_valid_in_command() {
		assertTrue(validator.accountTypeValid("create CheCkinG 12345673 9"));
		assertTrue(validator.accountTypeValid("create SaviNgS 12345674 9"));
		assertTrue(validator.accountTypeValid("create CD 12345675 9 2000"));
		assertFalse(validator.accountTypeValid("create checkng 22345672 8"));
		assertFalse(validator.accountTypeValid("create savigs 22345673 8"));
		assertFalse(validator.accountTypeValid("create CDS 22345674 8 1000"));
		assertFalse(validator.accountTypeValid("create new 22345674 8 1000"));
	}

	@BeforeEach
	void setUp() {
		validator = new Validator();
	}

	@Test
	void command_length_is_right() {
		assertTrue(validator.commandArguments("create CD 12345672 9 2000"));
		assertTrue(validator.commandArguments("create checking 12345670 9"));
		assertTrue(validator.commandArguments("create CD 12345672 9 2000"));
		assertFalse(validator.commandArguments("create CD 42345671 11"));
		assertFalse(validator.commandArguments("create checking 42345672"));
		assertFalse(validator.commandArguments("create savings 42345673"));
		assertFalse(validator.commandArguments("create savings 42345674 9 1600"));
		assertFalse(validator.commandArguments("create savings 42345675 10 1788"));
		assertFalse(validator.commandArguments("create CD 42345676 10 1788 89"));

	}

	@Test
	void create_is_valid_in_command() {
		assertTrue(validator.createValid("create CheCkinG 12345673 9"));
		assertTrue(validator.createValid("CreAte CheCkinG 12345673 9"));
		assertFalse(validator.createValid("make checkings 12345676 9"));
		assertFalse(validator.createValid("Kriate cheackings 12345677 9"));
		assertFalse(validator.createValid("make savings 12345678 9"));
		assertFalse(validator.createValid("Kriate savings 12345679 9"));
		assertFalse(validator.createValid("make CD 22345670 9 1000"));
		assertFalse(validator.createValid("Kriate CD 22345671 9 1000"));

	}

	@Test
	void uniqueid_is_valid() {
		assertTrue(validator.uniqueidValid("create checking 12345678 9"));
		assertFalse(validator.uniqueidValid("create checking 1234567 9"));
		assertFalse(validator.uniqueidValid("create savings 1234567 9"));
		assertFalse(validator.uniqueidValid("create CD 1234567 9 1000"));
		assertFalse(validator.uniqueidValid("create checking 12347655670 9"));
		assertFalse(validator.uniqueidValid("create savings 12343455671 9"));
		assertFalse(validator.uniqueidValid("create CD 12345643272 9 2000"));
		assertFalse(validator.uniqueidValid("create CD A2345675 0 1000"));
		assertFalse(validator.uniqueidValid("create checking A2345676 0"));
		assertFalse(validator.uniqueidValid("create savings A2345677 0"));

	}

	@Test
	void id_is_unique() {
		Bank bank = new Bank();
		bank.create(12345670, account);
		bank.create(12345671, savings);
		bank.create(12345672, cd);
		assertFalse(validator.idIsUnique("create checking 12345670 9"));
		assertFalse(validator.idIsUnique("create savings 12345671 9"));
		assertFalse(validator.idIsUnique("create CD 12345672 9 1000"));

	}

	@Test
	void apr_is_valid() {
		assertTrue(validator.aprIsValid("create CD 22345675 0 1000"));
		assertTrue(validator.aprIsValid("create checking 22345676 0"));
		assertTrue(validator.aprIsValid("create savings 22345677 0"));
		assertTrue(validator.aprIsValid("create CD 22345678 10 1000"));
		assertTrue(validator.aprIsValid("create checking 22345679 10"));
		assertTrue(validator.aprIsValid("create savings 32345670 10"));
		assertFalse(validator.aprIsValid("create CD 32345671 11 1000"));
		assertFalse(validator.aprIsValid("create checking 32345672 11"));
		assertFalse(validator.aprIsValid("create savings 32345673 11"));
		assertFalse(validator.aprIsValid("create CD 32345674 -2 1000"));
		assertFalse(validator.aprIsValid("create checking 32345675 -2"));
		assertFalse(validator.aprIsValid("create savings 32345676 -2"));
		assertFalse(validator.aprIsValid("create CD 52345675 A0 1000"));
		assertFalse(validator.aprIsValid("create checking 52345676 A0"));
		assertFalse(validator.aprIsValid("create savings 52345677 0B"));
		assertTrue(validator.aprIsValid("create checking 62345670 9.89"));
		assertTrue(validator.aprIsValid("create savings 62345671 9.67"));
		assertTrue(validator.aprIsValid("create CD 62345672 9.65 2000"));

	}

	@Test
	void amount_is_valid() {
		assertTrue(validator.amountIsValid("create CD 32345677 8 1000"));
		assertTrue(validator.amountIsValid("create CD 32345678 9 10000"));
		assertFalse(validator.amountIsValid("create CD 32345679 9 11000"));
		assertFalse(validator.amountIsValid("create CD 42345670 9 100"));
		assertFalse(validator.amountIsValid("create CD 52345675 8 1000A"));
		assertTrue(validator.amountIsValid("create CD 52345676 8 1000.87"));
		assertFalse(validator.amountIsValid("create CD 52345675 8 -1000"));

	}

	@Test
	void command_is_valid() {
		assertTrue(validator.commandValid("create checking 12345670 9"));
		assertTrue(validator.commandValid("create savings 12345671 9"));
		assertTrue(validator.commandValid("create CD 12345672 9 2000"));
		assertFalse(validator.commandValid("Create cD 1A345672 9 2000"));
		assertFalse(validator.commandValid("create savings 12345671 9 89"));
		assertFalse(validator.commandValid("Kreate CD 133456729 9 209070"));
		assertFalse(validator.commandValid("create CD   62345679 9 1000"));
		assertFalse(validator.commandValid("  create CD 72345679 9 1000"));
		assertTrue(validator.commandValid("create CD 72345670 9 1000  "));

	}

}
