public abstract class Account extends Bank {

	public double APR;
	public double amount;

	Account(double amount, double Apr) {
		this.amount = amount;
		this.APR = Apr;

	}

	@Override
	public abstract void deposit(Integer id, double amount);

	@Override
	public abstract void withdraw(Integer id, double amount);

	public abstract double getAmount(Integer id);

	public abstract double getAPR(Integer id);

}
