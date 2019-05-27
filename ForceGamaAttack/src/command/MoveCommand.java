package command;

import command.CommandType;
import jplay.Sprite;

public class MoveCommand {
	private double distanceToGo = 50;
	private CommandType direction;
	
	public MoveCommand(CommandType type) {
		this.direction = type;
	}
	
	public boolean execute(Sprite actor) {
		if (this.distanceToGo > 0) {
			moveActor(actor);
			this.distanceToGo -= 1;
			return false;
		} else {
			return true;
		}
	}
	public boolean execute(Sprite[] actors) {
		if (this.distanceToGo > 0) {
			for(Sprite actor: actors) {
				moveActor(actor);
			}
			this.distanceToGo -= 1;
			return false;
		} else {
			return true;
		}
	}
	
	private void moveActor(Sprite actor) {
		switch(this.direction) {
		case LEFT:
			actor.x -= 1;
			break;
		case DOWN:
			actor.y += 1;
			break;
		case RIGHT:
			actor.x += 1;
			break;
		case UP:
			actor.y -= 1;
			break;
		}
	}
}
