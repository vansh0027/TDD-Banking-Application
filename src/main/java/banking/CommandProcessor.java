package banking;

public class CommandProcessor {
	Bank bank;

	public CommandProcessor(Bank bank) {
		this.bank = bank;

	}

	public static void create(String s) {
		String arr[] = s.split(" ");
		int id = Integer.parseInt(arr[2]);
		double apr = Double.parseDouble(arr[3]);
		if (arr[1].equalsIgnoreCase("banking.Checking")) {
			Account checking = new Checking(0.00, apr);
			Bank.create(id, checking);

		} else if (arr[1].equalsIgnoreCase("banking.Savings")) {
			Account savings = new Savings(0.0, apr);
			Bank.create(id, savings);
		} else if (arr[1].equalsIgnoreCase("banking.CD")) {
			Account cd = new CD(Integer.parseInt(arr[4]), apr);
			Bank.create(id, cd);
		}

	}

	public static void deposit(String s) {
		String arr[] = s.split(" ");
		int id = Integer.parseInt(arr[1]);
		double amount = Double.parseDouble(arr[2]);
		((Account) Bank.getId(id)).deposit(id, amount);

	}

	public void processCommand(String command) {
		String arr[] = command.split(" ");
		if (arr[0].equalsIgnoreCase("create")) {
			create(command);
		} else if (arr[0].equalsIgnoreCase("deposit")) {
			deposit(command);
		}
	}
}
