import java.util.HashMap;

public class Bank {

	static HashMap<Integer, Object> bank;

	Bank() {
		bank = new HashMap<Integer, Object>();

	}

	public static void create(int id, Account account) {
		bank.put(id, account);
	}

	public static Object getID(int id) {
		return (Account) bank.get(id);

	}

	public int size() {
		return bank.size();
	}

	public void deposit(Integer id, double amount) {
		Account account = (Account) bank.get(id);
		account.deposit(id, amount);

	}

	public void withdraw(Integer id, double amount) {
		Account account = (Account) bank.get(id);
		account.withdraw(id, amount);
	}

	public void remove(Integer id) {
		bank.remove(id);
	}
}
