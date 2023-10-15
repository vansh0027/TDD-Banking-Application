import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void apr_is_same_as_provided_value() {
        assertEquals(APR, checking.APR);

    }

    @Test
    void deposit_in_account() {
        checking.deposit(ID, AMOUNT);
        assertEquals(AMOUNT, checking.getAmount(ID));
    }


    @Test
    void withdraw_from_account() {
        checking.deposit(ID, AMOUNT);
        checking.withdraw(ID, SUM);
        assertEquals((90), checking.getAmount(ID));

    }

    @Test
    void double_deposit_in_account() {
        checking.deposit(ID, AMOUNT);
        checking.deposit(ID, AMOUNT);
        assertEquals((2 * AMOUNT), checking.getAmount(ID));
    }

    @Test
    void double_withdraw_from_account() {
        checking.deposit(ID, AMOUNT);
        checking.withdraw(ID, SUM);
        checking.withdraw(ID, SUM);
        assertEquals((80), checking.getAmount(ID));

    }

    @Test
    void account_amount_cannot_be_negative() {
        checking.withdraw(ID, AMOUNT);
        assertEquals(0, checking.getAmount(ID));
    }


}
