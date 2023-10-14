public class Coffee extends Beverage {

	public static final int COFFEE_DEFAULT_SUGAR = 100;
	public static final int COFEE_COST = 300;

	public Coffee(double sugar) {
		super(sugar);
	}

	public Coffee() {
		super(COFFEE_DEFAULT_SUGAR);
	}

	@Override
	public int getPrice() {
		return COFEE_COST;
	}
}
