public abstract class Beverage {
	private double sugar;

	public Beverage(double sugar) {
		this.sugar = sugar;
	}

	public double getSugar() {
		return sugar;

	}

	public void addSugar(double sugarToAdd) {
		sugar += sugarToAdd;
	}

	public abstract int getPrice();
}
