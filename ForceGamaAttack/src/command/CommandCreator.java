package command;

public class CommandCreator {
	public static Command createCommand(CommandType type) {
		switch(type) {
		case UP:
			return (Command) new MoveCommand(CommandType.UP);
		default:
			return (Command) new MoveCommand(type);
		}
	}
}
