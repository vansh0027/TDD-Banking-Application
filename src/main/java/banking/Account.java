package banking;

public abstract class Account extends Bank {

	public double APR;
	public double amount;
	public int time = 0;
	public String accountType;

	Account(double amount, double Apr) {
		this.amount = amount;
		this.APR = Apr;
		this.time = 0;

	}

	@Override
	public abstract void depositIn(Integer id, double amount);

	public abstract void setTime(int time);

	@Override
	public abstract void withdrawFrom(Integer id, double amount);

	@Override
	public double getAmount(Integer id) {
		return amount;
	}

	public double getAPR(Integer id) {
		return this.APR;
	}

	public void passTimeCalc(Integer id, int months) {
		time += months;
		if (accountType.equalsIgnoreCase("CD")) {
			for (int i = 0; i < months; i++) {
				for (int j = 0; j < 4; j++) {
					amount += ((APR / 100) / 12) * amount;

				}
			}
		} else {
			for (int i = 0; i < months; i++) {
				amount += ((APR / 100) / 12) * amount;
			}
		}

	}

}
