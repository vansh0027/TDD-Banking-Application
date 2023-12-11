package banking;

public class TransferValidator {
	Bank bank;
	Validator validator;

	TransferValidator(Bank bank) {
		this.bank = bank;
		validator = new Validator(bank);

	}

	public boolean commandArguments(String s) {
		String arr[] = s.split(" ");
		if (arr.length != 4) {
			return false;
		} else {
			return true;
		}
	}

	public boolean transferValid(String s) {
		String arr[] = s.split(" ");
		if (arr[0].equalsIgnoreCase("transfer")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean accountExists(String s) {
		int id = Integer.parseInt(s);
		if (bank.containsKey(id)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean firstIdValid(String s) {
		String arr[] = s.split(" ");

		if ((bank.getId(Integer.parseInt(arr[1])) instanceof Savings)
				|| (bank.getId(Integer.parseInt(arr[1])) instanceof Checking)) {
			if (arr[1].length() == 8 && accountExists(arr[1])) {
				return true;
			} else {
				return false;
			}

		} else if (bank.getId(Integer.parseInt(arr[1])) instanceof CD) {
			return false;
		}
		return false;

	}

	public boolean secondIdValid(String s) {
		String arr[] = s.split(" ");

		if ((bank.getId(Integer.parseInt(arr[2])) instanceof Savings)
				|| (bank.getId(Integer.parseInt(arr[2])) instanceof Checking)) {
			if (arr[1].length() == 8 && accountExists(arr[2])) {
				return true;
			} else {
				return false;
			}

		} else if (bank.getId(Integer.parseInt(arr[2])) instanceof CD) {
			return false;
		}
		return false;
	}

	public boolean amountIsValid(String s) {
		String arr[] = s.split(" ");
		String deposit = "deposit " + arr[2] + " " + arr[3];
		String withdraw = "withdraw " + arr[1] + " " + arr[3];
		return (validator.validate(deposit) && validator.validate(withdraw));

	}

	public boolean validate(String s) {
		if (amountIsValid(s) && firstIdValid(s) && secondIdValid(s) && transferValid(s) & commandArguments(s)) {
			return true;
		} else {
			return false;
		}
	}

}
