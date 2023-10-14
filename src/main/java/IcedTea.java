public class IcedTea extends Beverage {

	public static final int ICED_TEA_COST = 200;
	public static final int ICED_TEA_DEFAULT_SUGAR = 50;

	public IcedTea(double sugar) {
		super(sugar);
	}

	public IcedTea() {
		super(ICED_TEA_DEFAULT_SUGAR);
	}

	@Override
	public int getPrice() {
		return ICED_TEA_COST;
	}

}
