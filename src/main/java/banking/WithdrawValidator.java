package banking;

public class WithdrawValidator {
	private final Bank bank;

	WithdrawValidator(Bank bank) {
		this.bank = bank;
	}

	public boolean withdrawValid(String s) {
		String arr[] = s.split(" ");
		if (arr[0].equalsIgnoreCase("withdraw")) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean withdrawIdValid(String s) {
		String arr[] = s.split(" ");
		if (arr[1].length() == 8) {
			try {
				Integer.parseInt(arr[1]);
				return true;

			} catch (Exception e) {
				return false;
			}

		} else {
			return false;
		}
	}

	public boolean withdrawAmountValid(String s) {
		String arr[] = s.split(" ");
		double amount = Double.parseDouble(arr[2]);
		if (withdrawIdValid(s)) {
			Account account = (Account) Bank.getId(Integer.parseInt(arr[1]));
			if (account instanceof Savings) {
				if (amount >= 0 && amount <= 1000) {
					return true;
				} else {
					return false;
				}

			} else if (account instanceof Checking) {
				if (amount >= 0 && amount <= 400) {
					return true;
				} else {
					return false;
				}

			} else if (account instanceof CD) {
				if (amount == account.amount || amount >= account.amount) {
					return true;
				} else {
					return false;
				}

			}

		} else {
			return false;
		}
		return false;
	}

	public boolean withdrawTimeValid(String s) {
		String arr[] = s.split(" ");
		Account account = (Account) Bank.getId(Integer.parseInt(arr[1]));
		int age = account.time;
		if (account instanceof Savings) {
			return !((Savings) account).getWithdrawalStatus();
		} else if (account instanceof CD) {
			if (account.time >= 12 && (account.time % 12 == 0)) {
				return true;
			} else {
				return false;
			}
		}
		return true;

	}

	public boolean validate(String s) {
		if (withdrawValid(s) && withdrawIdValid(s) && withdrawAmountValid(s) && withdrawTimeValid(s)) {
			return true;
		} else {
			return false;
		}
	}
}
