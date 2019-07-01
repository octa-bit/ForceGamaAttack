package player;

import java.awt.event.KeyEvent;

import constants.WindowConstants;

public class StructureStrategyJava extends Structure {
	
	private Player player;
	private static int javaHealth = 100;
	private final static String sprite = "src/graphics/img/java-ship.png";

	public StructureStrategyJava(int x, int y) {
		super(x, y, sprite, javaHealth);
		this.height = 40;
		this.width = 48;
		this.speed = 0.5;
		this.bulletSprite = "src/graphics/img/java-beam.png";
		this.gunShootingSpeed = 333;
		this.gunDamage = 50;
	}
	
	@Override
	public void moveX(double x) {
		if(this.getKeyboard().keyDown(KeyEvent.VK_RIGHT) &&
		   this.x + this.width < WindowConstants.WIDTH) {
			this.x += x / 2;
		}
		else if(this.getKeyboard().keyDown(KeyEvent.VK_LEFT) &&
				this.x > 0) {
			this.x -= x / 2;
		}
	}
	@Override
	public void moveY(double y) {
		if(this.getKeyboard().keyDown(KeyEvent.VK_DOWN) &&
		   this.y + this.height < WindowConstants.HEIGHT) {
			this.y += y / 2;
		}
		else if(this.getKeyboard().keyDown(KeyEvent.VK_UP) &&
				this.y > 0) {
			this.y -= y / 2;
		}
	}
}
