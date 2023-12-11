package banking;

public abstract class Account extends Bank {

	public double APR;
	public double amount;

	public int time = 0;

	Account(double amount, double Apr) {
		this.amount = amount;
		this.APR = Apr;
		this.time = 0;

	}

	@Override
	public abstract void deposit(Integer id, double amount);

	public abstract void setTime(int time);

	@Override
	public abstract void withdraw(Integer id, double amount);

	public abstract double getAmount(Integer id);

	public abstract double getAPR(Integer id);

}
