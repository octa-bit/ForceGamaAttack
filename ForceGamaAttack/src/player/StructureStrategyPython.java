package player;

import java.awt.event.KeyEvent;

import jplay.Keyboard;
import player.Player;

public class StructureStrategyPython extends Structure {
	
	private Player player;
	double speed = 1.0;
	private static int pythonHealth = 75;
	private final static String sprite = "src/graphics/img/python-ship.png";

	public StructureStrategyPython(int x, int y) {
		super(x, y, sprite, pythonHealth);
		this.height = 90;
		this.width = 50;
	}
	
	@Override
	public void moveX(double x) {
		if(this.getKeyboard().keyDown(KeyEvent.VK_RIGHT)) {
			this.x += x * speed;
		}
		else if(this.getKeyboard().keyDown(KeyEvent.VK_LEFT)) {
			this.x -= x * speed;
		}
	}
	
	@Override
	public void moveY(double y) {
		if(this.getKeyboard().keyDown(KeyEvent.VK_DOWN)) {
			this.y += y * speed;
		}
		else if(this.getKeyboard().keyDown(KeyEvent.VK_UP)) {
			this.y -= y * speed;
		}
	}
}
