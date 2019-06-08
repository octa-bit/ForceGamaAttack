package player;

import player.Player;

public class StructureStrategyPython extends Player {
	
	private Player player;
	double speed;
	private final static String sprite = "src/graphics/img/spaceshipPython.png";

	public StructureStrategyPython(int x, int y) {
		super(x, y, sprite);
	}
	
	public void move() {
		player.moveY(this.speed);
		player.moveX(this.speed);
	}
}
