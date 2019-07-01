package player;

import java.awt.event.KeyEvent;

import constants.WindowConstants;

public class StructureStrategyC extends player.Structure {

	private Player player;
	private static int cHealth = 50;
	private final static String sprite = "src/graphics/img/spaceship.png";

	public StructureStrategyC(int x, int y) {
		super(x, y, sprite, cHealth);
		this.height = 46;
		this.width = 18;
		this.speed = 2.0;
		this.bulletSprite = "src/graphics/img/c-beam.png";
		this.gunShootingSpeed = 111;
		this.gunDamage = 15;
	}
	
	@Override
	public void moveX(double x) {
		if(this.getKeyboard().keyDown(KeyEvent.VK_RIGHT) &&
		   this.x + this.width < WindowConstants.WIDTH) {
			this.x += x * 2;
		}
		else if(this.getKeyboard().keyDown(KeyEvent.VK_LEFT) &&
				this.x > 0) {
			this.x -= x * 2;
		}
	}
	@Override
	public void moveY(double y) {
		if(this.getKeyboard().keyDown(KeyEvent.VK_DOWN) &&
		   this.y + this.height < WindowConstants.HEIGHT) {
			this.y += y * 2;
		}
		else if(this.getKeyboard().keyDown(KeyEvent.VK_UP) &&
				this.y > 0) {
			this.y -= y * 2;
		}
	}
}
