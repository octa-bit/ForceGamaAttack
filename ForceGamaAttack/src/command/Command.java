package command;

import jplay.Sprite;

public interface Command {
	public boolean execute(Sprite actor);
}
