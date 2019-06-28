package player;
import java.awt.event.KeyEvent;

import jplay.Keyboard;

public class StructureStrategyJava extends Structure {
	
	private Player player;
	double speed = 0.5;
	private static int javaHealth = 100;
	private final static String sprite = "src/graphics/img/java-ship.png";

	public StructureStrategyJava(int x, int y) {
		super(x, y, sprite, javaHealth);
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
