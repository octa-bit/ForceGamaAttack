package player;

import java.awt.event.KeyEvent;

import constants.WindowConstants;

public class StructureStrategyPython extends Structure {
	
	private static int pythonHealth = 75;
	private final static String sprite = "src/graphics/img/python-ship.png";
	
	public StructureStrategyPython(int x, int y) {
		super(x, y, sprite, pythonHealth);
		this.height = 40;
		this.width = 50;
		this.speed = 1.0;
		this.bulletSprite = "src/graphics/img/python-beam.png";
		this.gunShootingSpeed = 222;
		this.gunDamage = 30;
	}
	
	@Override
	public void moveX(double x) {
		if(this.getKeyboard().keyDown(KeyEvent.VK_RIGHT) &&
		   this.x + this.width < WindowConstants.WIDTH) {
			this.x += x;
		}
		else if(this.getKeyboard().keyDown(KeyEvent.VK_LEFT) &&
				this.x > 0) {
			this.x -= x;
		}
	}

	@Override
	public void moveY(double y) {
		if(this.getKeyboard().keyDown(KeyEvent.VK_DOWN) &&
		   this.y + this.height < WindowConstants.HEIGHT) {
			this.y += y;
		}
		else if(this.getKeyboard().keyDown(KeyEvent.VK_UP) &&
				this.y > 0) {
			this.y -= y;
		}
	}
}
