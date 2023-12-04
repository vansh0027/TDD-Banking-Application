import java.util.List;

public class MasterControl {
	private Validator validator;

	private CommandStorage commandStorage;
	private CommandProcessor commandProcessor;

	public MasterControl(Validator validator, CommandProcessor commandProcessor, CommandStorage commandStorage) {
		this.validator = validator;
		this.commandProcessor = commandProcessor;
		this.commandStorage = commandStorage;
	}

	public List<String> start(List<String> input) {
		for (String command : input) {
			if (validator.validateCommand(command)) {
				commandProcessor.processCommand(command);

			} else {
				commandStorage.addInvalidCommand(command);
			}
		}
		return commandStorage.getInvalidCommands();
	}
}
