package banking;

public class CD extends Account {
	int time = 0;

	CD(double amount, double apr) {
		super(amount, apr);
		super.accountType = "CD";

	}

	@Override
	public double getAmount(Integer id) {
		return (super.amount);
	}

	@Override
	public void depositIn(Integer id, double amount) {
		super.amount = super.amount + amount;

	}

	@Override
	public void setTime(int time) {
		super.time = time;
	}

	@Override
	public void withdrawFrom(Integer id, double amount) {
		if (amount >= (super.amount)) {
			super.amount = (super.amount - amount);
		}
		if ((super.amount <= 0.00)) {
			super.amount = 0;

		}

	}

}
