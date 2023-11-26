public class Checking extends Account {
	double amount;
	double apr;

	Checking(Double amount, double apr) {
		super(0, apr);

	}

	public void Create(Integer id, Account account) {

		Bank.create(id, account);

	}

	@Override
	public double getAmount(Integer id) {
		return ((Checking) Bank.getId(id)).amount;
	}

	@Override
	public void deposit(Integer id, double amount) {
		((Checking) bank.get(id)).amount = ((Checking) bank.get(id)).amount + amount;

	}

	@Override
	public void withdraw(Integer id, double amount) {
		((Checking) bank.get(id)).amount = ((Checking) bank.get(id)).amount - amount;
		if (((Checking) bank.get(id)).amount <= 0.00) {
			((Checking) bank.get(id)).amount = 0;

		}
	}
}
