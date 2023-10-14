import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IcedTeaTest {
	IcedTea icedTea;

	@BeforeEach
	public void setUp() {
		icedTea = new IcedTea();
	}

	@Test
	public void iced_tea_can_be_created_with_50mg_sugar_by_default() {

		double actual = icedTea.getSugar();

		assertEquals(IcedTea.ICED_TEA_DEFAULT_SUGAR, actual);
	}

	@Test
	public void price_is_200_cents() {
		int actual = icedTea.getPrice();
		assertEquals(IcedTea.ICED_TEA_COST, actual);

	}
}
