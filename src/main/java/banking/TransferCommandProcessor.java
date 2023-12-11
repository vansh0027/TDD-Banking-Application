package banking;

public class TransferCommandProcessor {
	Bank bank;

	public TransferCommandProcessor(Bank bank) {
		this.bank = bank;
	}

	public void transfer(String command) {
		String arr[] = command.split(" ");
		int transferFrom = Integer.parseInt(arr[1]);
		int transferTo = Integer.parseInt(arr[2]);
		Double amount = Double.parseDouble(arr[3]);
		bank.transfer(transferFrom, transferTo, amount);

	}

}
