package banking;

public class DepositValidator {
	private final Bank bank;

	DepositValidator(Bank bank) {
		this.bank = bank;
	}

	public boolean depositValid(String s) {
		String arr[] = s.split(" ");
		if (arr[0].equalsIgnoreCase("deposit")) {

			return true;
		} else {
			return false;
		}
	}

	public boolean depositIdValid(String s) {
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

	public boolean depositAmountValid(String s) {
		String arr[] = s.split(" ");
		double amount = Double.parseDouble(arr[2]);
		if (depositIdValid(s)) {
			Account account = (Account) Bank.getId(Integer.parseInt(arr[1]));
			if (account instanceof Savings) {
				if (amount >= 0 && amount <= 2500) {
					return true;
				} else {
					return false;
				}

			} else if (account instanceof Checking) {
				if (amount >= 0 && amount <= 1000) {
					return true;
				} else {
					return false;
				}

			} else if (account instanceof CD) {
				return false;

			}

		} else {
			return false;
		}
		return false;

	}

	public boolean validate(String s) {
		if (depositValid(s) && depositIdValid(s) && depositAmountValid(s)) {
			return true;
		} else {
			return false;
		}
	}

}
