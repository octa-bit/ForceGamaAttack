package player;

import player.Player;

public class StructureStrategyPython extends Structure {
	
	private Player player;
	private static int pythonHealth = 75;
	private final static String sprite = "src/graphics/img/python-ship.png";

	public StructureStrategyPython(int x, int y) {
		super(x, y, sprite, pythonHealth);
		this.height = 40;
		this.width = 50;
		this.speed = 1.0;
	}
}
