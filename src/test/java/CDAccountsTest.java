import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void apr_is_same_as_provided_value() {
        assertEquals(APR, cd.APR);

    }

    @Test
    void deposit_in_account() {
        cd.deposit(ID, AMOUNT);
        assertEquals(2 * AMOUNT, cd.getAmount(ID));
    }


    @Test
    void withdraw_from_account() {

        cd.withdraw(ID, SUM);
        assertEquals((90), cd.getAmount(ID));

    }

    @Test
    void double_deposit_in_account() {
        cd.deposit(ID, AMOUNT);
        cd.deposit(ID, AMOUNT);
        assertEquals((3 * AMOUNT), cd.getAmount(ID));
    }

    @Test
    void double_withdraw_from_account() {

        cd.withdraw(ID, SUM);
        cd.withdraw(ID, SUM);
        assertEquals((80), cd.getAmount(ID));

    }

    @Test
    void account_amount_cannot_be_negative() {
        cd.withdraw(ID, AMOUNT);
        assertEquals(0, cd.getAmount(ID));
    }
}
