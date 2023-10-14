public class Bar {
	int tab;

	public int getTab() {
		return tab;
	}

	public void addBeverage(Beverage beverage) {
		tab += beverage.getPrice();
	}
}
