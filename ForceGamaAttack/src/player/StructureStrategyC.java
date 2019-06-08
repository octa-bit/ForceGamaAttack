package player;

import java.awt.event.KeyEvent;

import jplay.Keyboard;

public class StructureStrategyC extends Player {
	
	private Player player;
	double speed;
	private final static String sprite = "src/graphics/img/spaceship.png";

	public StructureStrategyC(int x, int y, Keyboard keyboard) {
		super(x, y, sprite, keyboard);
	}
	
	@Override
	public void moveX(double x) {
		if(this.keyboard.keyDown(KeyEvent.VK_RIGHT)) {
			this.x += x;
		}
		else if(this.keyboard.keyDown(KeyEvent.VK_LEFT)) {
			this.x -= x;
		}
	}
	
	@Override
	public void moveY(double y) {
		if(this.keyboard.keyDown(KeyEvent.VK_DOWN)) {
			this.y += y;
		}
		else if(this.keyboard.keyDown(KeyEvent.VK_UP)) {
			this.y -= y;
		}
	}
}
