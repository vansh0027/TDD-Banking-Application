import java.util.ArrayList;
import java.util.List;

public class CommandStorage {
	Bank bank;
	List<String> invalidCommandList = new ArrayList<>();

	CommandStorage(Bank bank) {
		this.bank = bank;

	}

	public List<String> getInvalidCommands() {
		return invalidCommandList;

	}

	public void addInvalidCommand(String s) {
		invalidCommandList.add(s);
	}
}
