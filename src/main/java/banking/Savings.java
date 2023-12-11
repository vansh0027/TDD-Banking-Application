package banking;

public class Savings extends Account {
	double amount;
	double apr;
	int time;
	boolean status = false;

	Savings(Double amount, double apr) {
		super(0, apr);

	}

	void changeWithdrawalStatus() {
		this.status = !(this.status);

	}

	boolean getWithdrawalStatus() {
		return this.status;
	}

	@Override
	public void setTime(int time) {
		if (time > super.time) {
			status = false;
		}
		super.time = time;
	}

	public void Create(Integer id, Account account) {

		Bank.create(id, account);

	}

	@Override
	public double getAmount(Integer id) {
		return ((Savings) Bank.getId(id)).amount;
	}

	@Override
	public void deposit(Integer id, double amount) {
		((Savings) bank.get(id)).amount = ((Savings) bank.get(id)).amount + amount;

	}

	@Override
	public void withdraw(Integer id, double amount) {
		((Savings) bank.get(id)).amount = ((Savings) bank.get(id)).amount - amount;
		if (((Savings) bank.get(id)).amount <= 0.00) {
			((Savings) bank.get(id)).amount = 0;
			changeWithdrawalStatus();

		}

	}

	@Override
	public double getAPR(Integer id) {
		return ((Savings) Bank.getId(id)).APR;
	}
}
