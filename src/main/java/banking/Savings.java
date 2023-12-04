package banking;

public class Savings extends Account {
	double amount;
	double apr;

	Savings(Double amount, double apr) {
		super(0, apr);

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

		}

	}

	@Override
	public double getAPR(Integer id) {
		return ((Savings) Bank.getId(id)).APR;
	}
}
