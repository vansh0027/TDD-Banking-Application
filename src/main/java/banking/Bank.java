package banking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {

	private final HashMap<Integer, Object> bank;

	Bank() {
		bank = new HashMap<Integer, Object>();

	}

	public void create(int id, Account account) {
		bank.put(id, account);
	}

	public Account getId(int id) {
		return (Account) bank.get(id);

	}

	HashMap<Integer, Object> getAccounts() {
		return bank;
	}

	public double getAmount(Integer id) {
		Account account = (Account) bank.get(id);
		return ((Account) bank.get(id)).getAmount(id);
	}

	public void bankTransfer(int transferFrom, int transferTo, Double amount) {
		((Account) bank.get(transferTo)).depositIn(transferTo, amount);
		((Account) bank.get(transferFrom)).withdrawFrom(transferFrom, amount);

	}

	public void depositIn(Integer id, double amount) {
		Account account = (Account) bank.get(id);
		account.depositIn(id, amount);

	}

	public void withdrawFrom(Integer id, double amount) {
		Account account = (Account) bank.get(id);
		account.withdrawFrom(id, amount);
	}

	public int size() {
		return bank.size();
	}

	public void remove(Integer id) {
		bank.remove(id);
	}

	public boolean containsKey(int id) {
		if (bank.containsKey(id)) {
			return true;

		}
		return false;
	}

	void passTime(int time) {
		List<Integer> accountsRemoved = new ArrayList<>();
		for (Integer id : bank.keySet()) {
			Account account = ((Account) bank.get(id));
			if (account.getAmount(id) == 0) {
				accountsRemoved.add(id);
				continue;
			}
			account.passTimeCalc(id, time);

		}

		for (Integer id : accountsRemoved) {
			bank.remove(id);
		}

	}

	public void transfer(Integer transferFrom, Integer transferTo, double amount) {
		double final_amount = amount;
		if (final_amount > ((Account) bank.get(transferFrom)).getAmount(transferFrom)) {

		}
		{
			final_amount = ((Account) bank.get(transferFrom)).getAmount(transferFrom);
		}

		((Account) bank.get(transferTo)).depositIn(transferTo, amount);
		((Account) bank.get(transferFrom)).withdrawFrom(transferFrom, amount);
	}

}
